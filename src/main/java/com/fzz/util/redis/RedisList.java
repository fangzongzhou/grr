package com.fzz.util.redis;

import redis.clients.jedis.Jedis;

import java.util.List;

/**
 * Created by tuyoo on 2017/3/22.
 */
public class RedisList {
    public static void main(String[] args) {
        Jedis jedis = new Jedis("localhost");
        System.out.println("connection to server successfully");
        jedis.lpush("sqllist", "orical");
        jedis.lpush("sqllist", "mysql");
        jedis.lpush("sqllist", "redis");
        jedis.lpush("sqllist", "sqlserver");
        jedis.lpush("sqllist", "mangodb");
        List<String> list=jedis.lrange("sqllist",0,10);
        for (String str:list
             ) {
            System.out.println("xianyoude sqlutil::  "+str);
        }
    }
}
