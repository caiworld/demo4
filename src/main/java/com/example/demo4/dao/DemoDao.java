package com.example.demo4.dao;

import com.example.demo4.entity.DemoDomain;
import com.github.pagehelper.Page;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface DemoDao {
    DemoDomain selectById(int id);

    void insert(DemoDomain demo);

    void updateById(DemoDomain demo);

    void deleteById(int id);

    List<DemoDomain> listDemos();

    Page<DemoDomain> findByPage();

    List<DemoDomain> dynamicWithSelect(DemoDomain demo);

    /**
     * 批量插入数据
     * @param list
     */
    void batchInsert(List<DemoDomain> list);

    /**
     * 查询id在ids里面的所有数据
     * @param ids
     * @return
     */
    List<DemoDomain> selectByIds(int... ids);

}
