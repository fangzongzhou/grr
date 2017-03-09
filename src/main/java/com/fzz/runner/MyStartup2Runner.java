package com.fzz.runner;

import org.springframework.boot.CommandLineRunner;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

/**
 * Created by fzz on 2017/2/28.
 */
@Component
@Order(value = 2)
public class MyStartup2Runner implements CommandLineRunner {
    @Override
    public void run(String... args) throws Exception {
        //System.out.println(">>>>>>>>>>>>>>>服务启动执行，执行加载数据等操作<<<<<<<<<<<<<");
    }
}
