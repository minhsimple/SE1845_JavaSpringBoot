package com.example.se1845.Config;

import javax.sql.DataSource;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.batch.core.Job;
import org.springframework.batch.core.Step;
import org.springframework.batch.core.configuration.annotation.EnableBatchProcessing;
import org.springframework.batch.core.job.builder.JobBuilder;
import org.springframework.batch.core.launch.support.RunIdIncrementer;
import org.springframework.batch.core.repository.JobRepository;
import org.springframework.batch.core.step.builder.StepBuilder;
import org.springframework.batch.item.ItemProcessor;
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

    @Bean
    public JdbcCursorItemReader<NotificationDTO> reader() {
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
    public ItemWriter<NotificationDTO> writer() {
        return items -> {
            for (NotificationDTO item : items) {
                MailBody mailBody = MailBody.builder()
                        .to("minhnbdhe180660@fpt.edu.vn")
                        .subject("Notification: " + item.getTitle())
                        .text(item.getDetail())
                        .build();

                emailService.sendSimpleMessage(mailBody);
            }
        };
    }

    @Bean
    public ItemProcessor<NotificationDTO, NotificationDTO> processor() {
        return new PassThroughItemProcessor<>();
    }

    @Bean
    public Step executeStep() {
        return new StepBuilder("executeStep", jobRepository)
                .<NotificationDTO, NotificationDTO>chunk(10, platformTransactionManager)
                .reader(reader())
                .processor(processor())
                .writer(writer())
                .build();
    }

    @Bean
    public Job processJob() {
        return new JobBuilder("processJob", jobRepository)
                .incrementer(new RunIdIncrementer())
                .start(executeStep())
                .build();
    }
}
