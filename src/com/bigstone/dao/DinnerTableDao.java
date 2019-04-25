package com.bigstone.dao;

import com.bigstone.domain.DinnerTable;
import com.bigstone.domain.FoodType;

import java.sql.SQLException;
import java.util.List;

/**
 * Created with IDEA
 * author:bigStone
 * Date:2019/4/25
 **/
public interface DinnerTableDao {

    /**添加*/
    void save(DinnerTable dinnerTable) throws SQLException;

    /**更新*/
    void update(DinnerTable dinnerTable) throws SQLException;

    /**删除*/
    void delete(int id) throws SQLException;

    /**根据主键查询*/
    DinnerTable findById(int id) throws SQLException;

    /**查询所有*/
    List<DinnerTable> getAll() throws SQLException;

}
