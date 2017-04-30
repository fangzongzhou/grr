package com.fzz.service;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;

/**
 * Created by fzz on 2017/4/30.
 */
@RunWith(SpringJUnit4ClassRunner.class)
@WebAppConfiguration
@SpringBootTest
public class UserServiceTest {

    @Autowired
    private UserService userService;

    @Test
    public void test() {
        userService.findByName("fzz");
        Assert.assertArrayEquals(
                new Object[]{
                        userService.findByName("fzz").getUsername(),
                        userService.findByName("grr").getUsername()
                },
                new Object[]{
                        "fzz",
                        "grr"
                }
        );
    }
}
