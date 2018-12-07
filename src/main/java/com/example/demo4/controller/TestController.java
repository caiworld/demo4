package com.example.demo4.controller;

import freemarker.template.Configuration;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;
import java.text.SimpleDateFormat;
import java.util.*;

@Controller
@RequestMapping("/test")
public class TestController {

  @RequestMapping("/test")
  public String test(ModelMap map, HttpServletRequest request) {
    // 创建一个合适的configuration对象
    Configuration configuration = new Configuration();
    // 获取或者创建一个模板
//        configuration.getTemplate("test.ftl");

    map.put("description", "这是一个freemarker Demo");

    List<String> nameList = new ArrayList<>();
    nameList.add("cai");
    nameList.add("hao");
    nameList.add("hello");
    map.put("nameList", nameList);

    Map<String, String> weaponMap = new HashMap<>();
    weaponMap.put("湖北", "黄石");
    weaponMap.put("河南", "洛阳");
    map.put("weaponMap", weaponMap);

    List<Map<String, Object>> animals = new ArrayList<>();
    Map<String, Object> map1 = new HashMap<>();
    Map map2 = new HashMap();
    map2.put("price", 3);
    map1.put("python", map2);
    animals.add(map1);
    map.put("animals", animals);
//    map.put("user","caihao");

    Map person = new HashMap();
    Map map3 = new HashMap();
    map3.put("name", "caihao");
    map3.put("age", 21);
    person.put("user", map3);
    map.put("person", person);

    // 日期
    map.put("date", new SimpleDateFormat("yyyy-MM-dd").format(new Date()));
    map.put("time", new SimpleDateFormat("HH:mm:ss").format(new Date()));
    map.put("date_time", new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(new Date()));

    map.put("boolean",true);
    return "test";
  }
}
