package com.example.demo4.service;

import com.example.demo4.entity.DemoDomain;
import com.github.pagehelper.Page;

import java.util.List;

public interface DemoService {
    DemoDomain selectById(int id);

    void insert(DemoDomain demo);

    void updateById(DemoDomain demo);

    void deleteById(int id);

    List<DemoDomain> listDemos();

    /**
     * 有条件的查询，查询条件不定
     *
     * @return 所有人员的一个集合
     */
    List<DemoDomain> dynamicWithSelect(DemoDomain demo);

    /**
     * 查询id在ids里面的所有数据
     * @param ids
     * @return
     */
    List<DemoDomain> selectByIds(int[] ids);

    void batchInsert(List<DemoDomain> list);

    Page<DemoDomain> findByPage();
}
