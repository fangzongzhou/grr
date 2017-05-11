package com.fzz;


import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.BeanUtils;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * Created by fzz on 2017/2/27.
 */
@SpringBootApplication
public class Aplication {
    private static Logger logger = LoggerFactory.getLogger(Aplication.class);
    public static void main(String[] args) {
        System.out.println("my web will be build , please waiting.");

        SpringApplication.run(Aplication.class,args);
    }

}
