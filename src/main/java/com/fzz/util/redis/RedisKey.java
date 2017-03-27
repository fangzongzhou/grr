package com.fzz.util.redis;

import redis.clients.jedis.Jedis;

import java.util.Iterator;
import java.util.List;
import java.util.Set;

/**
 * Created by tuyoo on 2017/3/22.
 */
public class RedisKey {
    public static void main(String[] args) {
        Jedis jedis = new Jedis("localhost");
        jedis.auth("root");
        System.out.println("connection successfully");
        System.out.println(jedis.ping());
        Set<String> set=jedis.keys("*");
        Iterator<String> iterator=set.iterator();
        while (iterator.hasNext()) {
            System.out.println(iterator.next());
        }


    }
}
