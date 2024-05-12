package com.example.se1845.Config;

import javax.sql.DataSource;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

import org.springframework.batch.core.Job;
import org.springframework.batch.core.Step;
import org.springframework.batch.core.configuration.annotation.EnableBatchProcessing;
import org.springframework.batch.core.job.builder.JobBuilder;
import org.springframework.batch.core.launch.support.RunIdIncrementer;
import org.springframework.batch.core.repository.JobRepository;
import org.springframework.batch.core.step.builder.StepBuilder;
import org.springframework.batch.item.ItemWriter;
import org.springframework.batch.item.database.JdbcCursorItemReader;
import org.springframework.batch.item.database.builder.JdbcCursorItemReaderBuilder;
import org.springframework.batch.item.support.PassThroughItemProcessor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.lang.Nullable;
import org.springframework.transaction.PlatformTransactionManager;

import com.example.se1845.dto.MailBody;
import com.example.se1845.dto.NotificationDTO;
import com.example.se1845.service.EmailService;

@Configuration
@EnableBatchProcessing
public class BatchConfig {

    @Autowired
    private PlatformTransactionManager platformTransactionManager;

    @Autowired
    private DataSource dataSource;

    @Autowired
    private EmailService emailService;

    @Autowired
    private JobRepository jobRepository;

    private List<String> emails;

    @Bean
    public JdbcCursorItemReader<String> emailAccountReader() {
        return new JdbcCursorItemReaderBuilder<String>()
                .dataSource(dataSource)
                .name("emailAccountReader")
                .sql("select Email from Employee")
                .rowMapper(new RowMapper<String>() {
                    @Override
                    @Nullable
                    @SuppressWarnings("null")
                    public String mapRow(ResultSet rs, int rowNum)
                            throws SQLException {
                        return rs.getString("Email");
                    }
                })
                .build();
    }

    @Bean
    public JdbcCursorItemReader<NotificationDTO> notificationReader() {
        return new JdbcCursorItemReaderBuilder<NotificationDTO>()
                .dataSource(dataSource)
                .name("notificationItemReader")
                .sql("select NotifyID, Title, Detail, Start, [End], SSN from Notification")
                .rowMapper(new RowMapper<NotificationDTO>() {
                    @Override
                    @Nullable
                    @SuppressWarnings("null")
                    public NotificationDTO mapRow(ResultSet rs, int rowNum)
                            throws SQLException {
                        return NotificationDTO.builder()
                                .notifyid(rs.getString("NotifyID"))
                                .title(rs.getString("Title"))
                                .detail(rs.getString("Detail"))
                                .start(rs.getString("Start"))
                                .end(rs.getString("End"))
                                .ssn(rs.getString("SSN"))
                                .build();
                    }
                })
                .build();
    }

    @Bean
    public ItemWriter<String> emailAccountWriter() {
        return items -> emails = new ArrayList<>(items.getItems());
    }

    @Bean
    public ItemWriter<NotificationDTO> sendEmail() {
        return items -> {
            ExecutorService firstExecutor = Executors.newFixedThreadPool(10);
            for (String email : emails) {
                firstExecutor.submit(() -> {
                    for (NotificationDTO item : items) {
                        MailBody mailBody = MailBody.builder()
                                .to(email)
                                .subject("Notification: " + item.getTitle())
                                .text(item.getDetail())
                                .build();

                        emailService.sendSimpleMessage(mailBody);
                    }
                });
            }
            firstExecutor.shutdown();
            try {
                // Wait until all tasks are finished
                firstExecutor.awaitTermination(Long.MAX_VALUE, TimeUnit.NANOSECONDS);
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
            }
        };
    }

    @Bean
    public Step readEmailAccountStep() {
        return new StepBuilder("readEmailAccountStep", jobRepository)
                .<String, String>chunk(10, platformTransactionManager)
                .reader(emailAccountReader())
                .processor(new PassThroughItemProcessor<>())
                .writer(emailAccountWriter())
                .build();
    }

    @Bean
    public Step sendEmailStep() {
        return new StepBuilder("sendEmailStep", jobRepository)
                .<NotificationDTO, NotificationDTO>chunk(10, platformTransactionManager)
                .reader(notificationReader())
                .processor(new PassThroughItemProcessor<>())
                .writer(sendEmail())
                .build();
    }

    @Bean
    public Job processJob() {
        return new JobBuilder("processJob", jobRepository)
                .incrementer(new RunIdIncrementer())
                .start(readEmailAccountStep())
                .next(sendEmailStep())
                .build();
    }
}
