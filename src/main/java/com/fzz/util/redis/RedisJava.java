package com.fzz.util.redis;

import redis.clients.jedis.Jedis;

/**
 * Created by tuyoo on 2017/3/22.
 */
public class RedisJava {
    public static void main(String[] args) {
        Jedis jedis = new Jedis("localhost");
        System.out.println("connection to server successfully");
        System.out.println("server is running : "+ jedis.ping());
    }
}
