package com.example.demo4.redis.service;

/**
 * @Description TODO
 * @Author 蔡浩
 * @Date 2018/11/28 17:18
 */
public interface MyRedisService {
  /**
   * set存数据
   *
   * @param key   键
   * @param value 值
   * @return 是否成功boolean
   * @Author 蔡浩
   * @Date 2018/11/28 17:20
   */
  boolean set(String key, String value);

  /**
   * get根据键取数据
   *
   * @param key 键
   * @return 值
   * @Author 蔡浩
   * @Date 2018/11/28 17:21
   */
  String get(String key);

  /**
   * 设置键的有效时间
   *
   * @param key    键
   * @param expire 有效时间
   * @Author 蔡浩
   * @Date 2018/11/28 17:22
   */
  boolean expire(String key, long expire);

  /**
   * 根据键移除数据
   *
   * @param key 键
   * @return boolean 是否成功
   * @Author 蔡浩
   * @Date 2018/11/28 17:24
   */
  boolean remove(String key);
}
