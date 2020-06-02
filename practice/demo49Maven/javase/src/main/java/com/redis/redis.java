package com.redis;

import java.util.Map;

import redis.clients.jedis.Jedis;


public class redis {
    public static void main(String[] args) {
        Jedis jedis = new Jedis("localhost", 6379);
        jedis.set("username", "zheng lin");
        String ret = jedis.get("username");
        System.out.println(ret);

        jedis.hset("users", "username", "jun tian");
        jedis.hset("users", "password", "123456");
        jedis.hset("users", "gender", "male");
        Map<String, String> map = jedis.hgetAll("users");

        System.out.println(map);

        jedis.close();
    }
}