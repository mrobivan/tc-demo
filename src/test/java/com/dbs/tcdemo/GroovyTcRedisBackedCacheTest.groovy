package com.dbs.tcdemo

import com.dbs.tcdemo.cache.RedisBackedCache
import org.testcontainers.containers.GenericContainer
import org.testcontainers.spock.Testcontainers
import spock.lang.Specification

@Testcontainers
class GroovyTcRedisBackedCacheTest extends Specification {

    private RedisBackedCache underTest

    GenericContainer redis = new GenericContainer<>("redis:5.0.3-alpine")
            .withExposedPorts(6379)

    void setup() {
        String address = redis.host
        Integer port = redis.firstMappedPort
        underTest = new RedisBackedCache(address, port)
    }

    void testSimpleSetAndGet() {
        setup:
        underTest.set("test", "example")

        when:
        String retrieved = underTest.get("test")

        then:
        retrieved == "example"

        print(redis.getLogs())
    }
}
