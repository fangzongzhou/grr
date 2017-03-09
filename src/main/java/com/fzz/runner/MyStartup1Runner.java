package com.fzz.runner;

import org.springframework.boot.CommandLineRunner;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

/**
 * Created by fzz on 2017/2/28.
 */
@Component
@Order(value = 1)
public class MyStartup1Runner implements CommandLineRunner {
    @Override
    public void run(String... args) throws Exception {

    }
}
