package com.redis;

import redis.clients.jedis.Jedis;

public class redis02Hash {
    public static void main(String[] args) {
        Jedis jedis = new Jedis();
        jedis.hset("users", "name", "Nancy");
        jedis.hset("users", "age", "28");
        jedis.hset("users", "gender", "female");

    }
}