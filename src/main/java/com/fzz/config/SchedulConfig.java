package com.fzz.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.scheduling.annotation.Scheduled;

/**
 * Created by tuyoo on 2017/3/31.
 */
@Configuration
@EnableScheduling
public class SchedulConfig {

    @Scheduled(cron = "0/5 * * * * ?")
    public void schedul() {
        //放置需要运行的定时任务，
    }
}
