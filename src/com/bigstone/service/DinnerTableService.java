package com.bigstone.service;

import com.bigstone.domain.DinnerTable;

import java.sql.SQLException;
import java.util.List;

/**
 * 餐桌管理service接口
 * Created with IDEA
 * author:bigStone
 * Date:2019/4/25
 **/
public interface DinnerTableService {

    /**添加*/
    void save(DinnerTable dinnerTable) ;

    /**更新*/
    void update(DinnerTable dinnerTable) ;

    /**删除*/
    void delete(int id) ;

    /**根据主键查询*/
    DinnerTable findById(int id) ;

    /**查询所有*/
    List<DinnerTable> getAll() ;

    List<DinnerTable> findByName(String tableName);

    void cancel(int id);
}
