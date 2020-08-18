package com.redis;

import java.util.Map;

import redis.clients.jedis.Jedis;
import redis.clients.jedis.JedisPool;
import redis.clients.jedis.JedisPoolConfig;

public class redis03Pool {
    public static void main(String[] args) {
        JedisPoolConfig jConfig = new JedisPoolConfig();
        jConfig.setMaxTotal(50);
        jConfig.setMaxIdle(10);

        JedisPool jPool = new JedisPool(jConfig, "localhost", 6379);
        Jedis jedis = jPool.getResource();
        Map<String, String> ret = jedis.hgetAll("users");
        System.out.println(ret);
        jedis.close();
        
        
    }
}