package com.redis;

import java.util.Map;

import redis.clients.jedis.Jedis;
import redis.clients.jedis.JedisPool;

public class redis04Pool {
    public static void main(String[] args) {
        JedisPool jPool = redisUtils.getJedisPool();
        Jedis jedis = jPool.getResource();
        Map<String, String> ret = jedis.hgetAll("users");
        System.out.println(ret);
        jedis.close();
    }
}