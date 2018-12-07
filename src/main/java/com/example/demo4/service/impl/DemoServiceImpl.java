package com.example.demo4.service.impl;

import com.example.demo4.dao.DemoDao;

import com.example.demo4.entity.DemoDomain;
import com.example.demo4.service.DemoService;
import com.github.pagehelper.Page;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DemoServiceImpl implements DemoService {
    @Autowired
    private DemoDao demoDao;

    @Override
    public DemoDomain selectById(int id) {
        return demoDao.selectById(id);
    }

    @Override
    public void insert(DemoDomain demo) {
        demoDao.insert(demo);
    }

    @Override
    public void updateById(DemoDomain demo) {
        demoDao.updateById(demo);
    }

    @Override
    public void deleteById(int id) {
        demoDao.deleteById(id);
    }

    @Override
    public List<DemoDomain> listDemos() {
        return demoDao.listDemos();
    }

    @Override
    public List<DemoDomain> dynamicWithSelect(DemoDomain demo) {
        return demoDao.dynamicWithSelect(demo);
    }

    @Override
    public List<DemoDomain> selectByIds(int[] ids) {
        return demoDao.selectByIds(ids);
    }

    @Override
    public void batchInsert(List<DemoDomain> list) {
        demoDao.batchInsert(list);
    }

    @Override
    public Page<DemoDomain> findByPage() {
        return demoDao.findByPage();
    }
}
