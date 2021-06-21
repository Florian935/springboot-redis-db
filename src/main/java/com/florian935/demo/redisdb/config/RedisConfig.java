package com.florian935.demo.redisdb.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.redis.connection.RedisStandaloneConfiguration;
import org.springframework.data.redis.connection.jedis.JedisConnectionFactory;
import org.springframework.data.redis.core.RedisTemplate;

/**
 * @author florian935
 */
@Configuration
public class RedisConfig {
    private static final String LOCALHOST = "localhost";
    private static final int PORT = 6379;

    @Bean
    JedisConnectionFactory jedisConnectionFactory() {

        final RedisStandaloneConfiguration redisStandaloneConfiguration =
                new RedisStandaloneConfiguration(LOCALHOST, PORT);
        redisStandaloneConfiguration.setDatabase(5);

        return new JedisConnectionFactory(redisStandaloneConfiguration);
    }

    @Bean
    RedisTemplate<String, ?> redisTemplate() {

        final RedisTemplate<String, ?> redisTemplate = new RedisTemplate<>();
        redisTemplate.setConnectionFactory(jedisConnectionFactory());

        return redisTemplate;
    }
}
