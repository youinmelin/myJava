package com.redis;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;
import java.util.Set;

import redis.clients.jedis.JedisPool;
import redis.clients.jedis.JedisPoolConfig;

public class redisUtils {

    private static JedisPool jedisPool;
    static{
        Properties prop = new Properties();
        InputStream is = redisUtils.class.getClassLoader().getResourceAsStream("jedis.properties");
        try {
            prop.load(is);
        } catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        JedisPoolConfig poolConfig = new JedisPoolConfig();
        poolConfig.setMaxTotal(Integer.parseInt(prop.getProperty("maxTotal")));
        poolConfig.setMaxIdle(Integer.parseInt(prop.getProperty("maxIdle")));
        
        jedisPool = new JedisPool(poolConfig,prop.getProperty("host"), Integer.parseInt(prop.getProperty("port")));
        Set<String> configSet = prop.stringPropertyNames();
        System.out.println(configSet);

    }
    public static JedisPool getJedisPool() {
        return jedisPool;
        
    }
}