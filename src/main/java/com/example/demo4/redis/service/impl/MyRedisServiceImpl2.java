package com.example.demo4.redis.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.core.ValueOperations;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

/**
 * @Description TODO
 * @Author 蔡浩
 * @Date 2018/11/28 21:18
 */
@Service
public class MyRedisServiceImpl2 {

//  @Autowired
//  private EmpDao empDao;

  @Autowired
  private RedisTemplate redisTemplate;

  public List<String> getEmp() {

    // 从缓存中获取员工信息

    String key = "emp_list";

    List<String> list = new ArrayList<>();

    ValueOperations<String, List<String>> operations = redisTemplate.opsForValue();

    boolean hasKey = redisTemplate.hasKey(key);

    if (hasKey) {
      list = operations.get(key);
      System.out.println("list.size " + list.size());
      return list;
    }
    // 插入缓存
    operations.set(key, list);
    System.out.println("员工插入缓存,员工个数 >> " + list.size());
    return list;

  }

//  public String getEmpByEmpno(String empno) {
//    // 从缓存中获取员工信息
//    String key = "emp_" + empno;
//    ValueOperations<String, Emp> operations = redisTemplate.opsForValue();
//    // 缓存存在
//    boolean hasKey = redisTemplate.hasKey(key);
//    if (hasKey) {
//      Emp emp = operations.get(key);
//      System.out.println("从缓存中获取了员工 >> " + emp.toString());
//      return emp;
//    }
//    // 从 DB 中获取城市信息
//    Emp emp = empDao.getEmpByEmpno(empno);
//    // 插入缓存
//    operations.set(key, emp);
//    System.out.println("员工插入缓存 >> " + emp.toString());
//    return emp;
//  }
}
