package com.fzz;


import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * Created by fzz on 2017/2/27.
 */
@SpringBootApplication
public class Aplication {


    public static void main(String[] args) {
        System.out.println("my web will be build , please waiting.");
        SpringApplication.run(Aplication.class,args);
    }



}
