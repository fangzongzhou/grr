package com.fzz.controller;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.*;
import org.junit.runner.RunWith;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

/**
 * Created by fzz on 2017/4/30.
 */
@RunWith(SpringRunner.class)
@SpringBootTest
public class UserControllerTest {
    @Autowired
    UserController userController;



    @org.junit.Test
    public void test () throws Exception{
        assertThat(userController).isNotNull();

    }
}
