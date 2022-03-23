package com.dbs.tcdemo.cache;

import redis.clients.jedis.Jedis;

public class RedisBackedCache {

    private final Jedis jedis;

    public RedisBackedCache(String redisHost, int portNumber) {
        this.jedis = new Jedis(redisHost, portNumber);
    }

    public void set(String key, String value) {
        this.jedis.set(key, value);
    }

    public String get(String key) {
        return this.jedis.get(key);
    }

}
