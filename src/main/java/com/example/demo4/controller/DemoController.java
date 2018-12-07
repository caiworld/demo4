package com.example.demo4.controller;

import com.example.demo4.entity.DemoDomain;
import com.example.demo4.service.DemoService;
import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.ArrayList;
import java.util.List;

@Controller
@RequestMapping(value = "/demo")
public class DemoController {
    @Autowired
    private DemoService demoService;

    @ResponseBody
    @RequestMapping("/selectById")
    public DemoDomain selectById(int id) {
        return demoService.selectById(id);
    }

    @ResponseBody
    @RequestMapping("/add")
    public void add() {
        DemoDomain demo = new DemoDomain();
        demo.setId(2);
        demo.setName("hao");
        demo.setAge(22);
        demoService.insert(demo);
    }

    @ResponseBody
    @RequestMapping("/update")
    public void update() {
        DemoDomain demo = new DemoDomain();
        demo.setId(2);
        demo.setName("women");
        demo.setAge(2);
        demoService.updateById(demo);
    }

    @ResponseBody
    @RequestMapping("/delete")
    public void deleteById() {
        demoService.deleteById(2);
    }

    /**
     * 查询所有数据
     *
     * @return
     */
    @ResponseBody
    @RequestMapping("/list")
    public List<DemoDomain> listDemos() {
        List<DemoDomain> list = demoService.listDemos();
        for (DemoDomain demo : list) {
            System.out.println(demo.getName() + demo.getAge());
        }
        return list;
    }

    /**
     * 分页查询数据
     *
     * @return
     */
    @ResponseBody
    @RequestMapping("/fy")
    public PageInfo<DemoDomain> selectWithFY() {
        PageHelper.startPage(1,2);
        List<DemoDomain> list = demoService.listDemos();
        for (DemoDomain demo : list) {
            System.out.println(demo.getName() + demo.getAge());
        }
        // 返回PageInfo的json
        return new PageInfo<DemoDomain>(list);
    }

    /**
     * 分页查询数据2
     *
     * @return
     */
    @ResponseBody
    @RequestMapping("/fy2")
    public Page<DemoDomain> selectWithFY2() {
        PageHelper.startPage(1,2);
//        List<DemoDomain> list = demoService.findByPage();
//        for (DemoDomain demo : list) {
//            System.out.println(demo.getName() + demo.getAge());
//        }

        return demoService.findByPage();
    }



    /**
     * 有条件的查询，查询条件不定
     *
     * @param name 姓名
     * @param age  年龄
     * @return 所有人员的一个集合
     */
    @ResponseBody
    @RequestMapping("/dynamic")
    public List<DemoDomain> dynamicWithSelect(String name, Integer age) {
        DemoDomain demo = new DemoDomain();
        demo.setName(name);
        demo.setAge(age);
        List<DemoDomain> list = demoService.dynamicWithSelect(demo);
        for (DemoDomain demoDomain : list) {
            System.out.println(demoDomain.getName() + "::" + demoDomain.getAge());
        }
        return list;
    }

    /**
     * 查询id在ids里面的所有数据
     *
     * @param ids
     * @return
     */
    @ResponseBody
    @RequestMapping("/ids")
    public List<DemoDomain> selectByIds(int[] ids) {
        List<DemoDomain> list = demoService.selectByIds(ids);
        for (DemoDomain demo : list) {
            System.out.println(demo.getName() + ";;" + demo.getAge());
        }
        return list;
    }

    @ResponseBody
    @RequestMapping("/batchInsert")
    public void batchInsert() {
        List<DemoDomain> list = new ArrayList<>();
        list.add(new DemoDomain(3, "hello", 21));
        list.add(new DemoDomain(4, "world", 22));
        list.add(new DemoDomain(5, "java", 23));
        demoService.batchInsert(list);
    }

}
