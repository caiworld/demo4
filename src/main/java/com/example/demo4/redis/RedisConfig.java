package com.example.demo4.redis;

import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.redis.connection.jedis.JedisConnectionFactory;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.core.StringRedisTemplate;
import redis.clients.jedis.JedisPoolConfig;

/**
 * @Description TODO
 * @Author 蔡浩
 * @Date 2018/11/28 17:11
 */
@Configuration
@EnableAutoConfiguration
public class RedisConfig {
  @Bean
  @ConfigurationProperties(prefix = "spring.redis.pool")
  public JedisPoolConfig getRedisConfig() {
    JedisPoolConfig config = new JedisPoolConfig();
    return config;
  }

  @Bean
  @ConfigurationProperties(prefix = "spring.redis")
  public JedisConnectionFactory getConnectionFactory() {
    JedisConnectionFactory factory = new JedisConnectionFactory();
    factory.setUsePool(true);
    JedisPoolConfig config = getRedisConfig();
    factory.setPoolConfig(config);
    return factory;
  }

  @Bean
  public RedisTemplate<?, ?> getRedisTemplate() {
    JedisConnectionFactory factory = getConnectionFactory();
    RedisTemplate<?, ?> template = new StringRedisTemplate(factory);
    return template;
  }
}
