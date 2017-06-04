package com.fzz.config;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.annotation.Configuration;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.scheduling.annotation.Scheduled;

import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * Created by tuyoo on 2017/3/31.
 */
@Configuration

public class SchedulConfig {
    private static final Logger log= LoggerFactory.getLogger(SchedulConfig.class);
    private  static  final SimpleDateFormat dateFormat=new SimpleDateFormat("HH:mm:ss");

    @Scheduled(cron = "0/5 * * * * ?")
    public void schedul() {
        //放置需要运行的定时任务，
//        log.info("当前时间: {}",dateFormat.format(new Date()));
    }
}
