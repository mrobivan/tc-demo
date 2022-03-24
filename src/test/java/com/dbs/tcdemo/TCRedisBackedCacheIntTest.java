package com.dbs.tcdemo;

import com.dbs.tcdemo.cache.RedisBackedCache;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.testcontainers.containers.GenericContainer;
import org.testcontainers.junit.jupiter.Container;
import org.testcontainers.junit.jupiter.Testcontainers;
import org.testcontainers.utility.DockerImageName;

import static org.junit.jupiter.api.Assertions.assertEquals;

@Testcontainers
public class TCRedisBackedCacheIntTest {
    private RedisBackedCache underTest;

    @Container
    GenericContainer redis = new GenericContainer(DockerImageName.parse("redis:5.0.3-alpine"))
            .withExposedPorts(6379);


    @BeforeEach
    public void setUp() {

        String redisHost = redis.getHost();
        Integer port = redis.getFirstMappedPort();

        underTest = new RedisBackedCache(redisHost, port);
    }

    @Test
    public void testSimplePutAndGet() {
        underTest.set("test", "example");

        String retrieved = underTest.get("test");
        assertEquals("example", retrieved);
    }
}
