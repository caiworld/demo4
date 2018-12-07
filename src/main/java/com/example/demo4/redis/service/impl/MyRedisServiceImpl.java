package com.example.demo4.redis.service.impl;

import com.example.demo4.redis.service.MyRedisService;
import org.springframework.dao.DataAccessException;
import org.springframework.data.redis.connection.RedisConnection;
import org.springframework.data.redis.core.RedisCallback;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.serializer.RedisSerializer;
import org.springframework.lang.Nullable;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.concurrent.TimeUnit;

/**
 * @Description TODO
 * @Author 蔡浩
 * @Date 2018/11/28 17:25
 */
@Service("redisService")
public class MyRedisServiceImpl implements MyRedisService {
  @Resource
  private RedisTemplate<String, ?> redisTemplate;

  @Override
  public boolean set(String key, String value) {
    Boolean result = redisTemplate.execute(new RedisCallback<Boolean>() {
      @Nullable
      @Override
      public Boolean doInRedis(RedisConnection redisConnection) throws DataAccessException {
        RedisSerializer<String> serializer = redisTemplate.getStringSerializer();
        redisConnection.set(serializer.serialize(key), serializer.serialize(value));
        return true;
      }
    });
    return result;
  }

  @Override
  public String get(String key) {
    String result = redisTemplate.execute(new RedisCallback<String>() {
      @Nullable
      @Override
      public String doInRedis(RedisConnection redisConnection) throws DataAccessException {
        RedisSerializer<String> serializer = redisTemplate.getStringSerializer();
        byte[] value = redisConnection.get(serializer.serialize(key));
        return serializer.deserialize(value);
      }
    });
    return result;
  }

  @Override
  public boolean expire(String key, long expire) {
    return redisTemplate.expire(key, expire, TimeUnit.SECONDS);
  }

  @Override
  public boolean remove(String key) {
    Boolean result = redisTemplate.execute(new RedisCallback<Boolean>() {
      @Nullable
      @Override
      public Boolean doInRedis(RedisConnection redisConnection) throws DataAccessException {
        RedisSerializer<String> serializer = redisTemplate.getStringSerializer();
        redisConnection.del(key.getBytes());
        return true;
      }
    });
    return result;
  }
}
