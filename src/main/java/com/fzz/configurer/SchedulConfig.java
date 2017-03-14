package com.fzz.configurer;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.annotation.Configuration;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.scheduling.annotation.Scheduled;


/**
 * Created by fzz on 2017/2/28.
 */
@Configuration
@EnableScheduling//定时任务配置类
public class SchedulConfig {

    private final Logger logger= LoggerFactory.getLogger(getClass());
    /*@Scheduled(cron = "0/20 * * * * ?")
    public void test() {
        logger.info(".....schedul");
    }*/
}
