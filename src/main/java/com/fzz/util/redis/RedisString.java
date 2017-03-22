package com.fzz.util.redis;

import redis.clients.jedis.Jedis;

/**
 * Created by tuyoo on 2017/3/22.
 */
public class RedisString {
    public static void main(String[] args) {
        Jedis jedis = new Jedis("localhost");
        System.out.println("connection to server successfully");
        jedis.set("username", "fangzongzhou");
        System.out.println("username:: " + jedis.get("username"));
    }
}
