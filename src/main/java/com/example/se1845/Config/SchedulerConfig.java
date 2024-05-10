package com.example.se1845.Config;

import org.springframework.batch.core.Job;
import org.springframework.batch.core.JobParametersBuilder;
import org.springframework.batch.core.launch.JobLauncher;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.scheduling.annotation.Scheduled;

import lombok.extern.slf4j.Slf4j;

@Configuration
@EnableScheduling
@Slf4j
public class SchedulerConfig {

    @Autowired
    private JobLauncher jobLauncher;

    @Autowired
    private Job job;

    @Scheduled(cron = "0 30 8  * * ?")
    public void sendNotificationMailJob() {
        log.info("Email sending . . .");
        try {
            jobLauncher.run(job,
                    new JobParametersBuilder().addLong("startAt", System.currentTimeMillis()).toJobParameters());
        } catch (Exception e) {
            e.printStackTrace();
        }
        log.info("Task completed . . .");
    }

}
