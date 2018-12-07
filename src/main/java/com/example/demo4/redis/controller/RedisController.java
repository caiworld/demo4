package com.example.demo4.redis.controller;

import com.example.demo4.redis.service.impl.MyRedisServiceImpl2;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

/**
 * @Description TODO
 * @Author 蔡浩
 * @Date 2018/11/28 21:24
 */
@Controller
@RequestMapping(value = "/redis")
public class RedisController {
  @Autowired
  private MyRedisServiceImpl2 service;

  @ResponseBody
  @RequestMapping("/select")
  public List<String> selectById(int id) {
    return service.getEmp();
  }

}
