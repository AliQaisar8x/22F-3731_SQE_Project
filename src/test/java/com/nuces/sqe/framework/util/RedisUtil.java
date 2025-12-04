package com.nuces.sqe.framework.util;

import com.nuces.sqe.framework.core.ConfigReader;
import redis.clients.jedis.Jedis;
import redis.clients.jedis.JedisPool;
import redis.clients.jedis.JedisPoolConfig;

import java.util.Properties;

public class RedisUtil {

    private static final Properties props = ConfigReader.load("redis.properties");
    private static final JedisPool pool;

    static {
        JedisPoolConfig config = new JedisPoolConfig();
        String host = props.getProperty("redis.host", "localhost");
        int port = Integer.parseInt(props.getProperty("redis.port", "6379"));
        pool = new JedisPool(config, host, port);
    }

    public static void setToken(String key, String value) {
        try (Jedis jedis = pool.getResource()) {
            jedis.set(key, value);
        }
    }

    public static String getToken(String key) {
        try (Jedis jedis = pool.getResource()) {
            return jedis.get(key);
        }
    }
}


