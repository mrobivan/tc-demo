package com.dbs.tcdemo;

import com.dbs.tcdemo.cache.RedisBackedCache;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class RedisBackedCacheIntTest {
    private RedisBackedCache underTest;

    @BeforeEach
    public void setUp() {
        // Assume that we have Redis running locally?
        underTest = new RedisBackedCache("localhost", 6379);
    }

    @Test
    public void testSimplePutAndGet() {
        underTest.set("test", "example");

        String retrieved = underTest.get("test");
        assertEquals("example", retrieved);
    }
}
