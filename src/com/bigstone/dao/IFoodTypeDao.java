package com.bigstone.dao;

import com.bigstone.domain.FoodType;

import java.sql.SQLException;
import java.util.List;

/**
 * FoodType Date Access Object Interface
 * Created with IDEA
 * author: bigStone
 * Date:2019/4/22
 * Time:19:02
 */
public interface IFoodTypeDao {

    /**添加*/
    void save(FoodType foodType) throws SQLException;

    /**更新*/
    void update(FoodType foodType) throws SQLException;

    /**删除*/
    void delete(int id) throws SQLException;

    /**根据主键查询*/
    FoodType findById(int id) throws SQLException;

    /**查询所有*/
    List<FoodType> getAll(String name) throws SQLException;


    /**根据菜系名称查询*/
    List<FoodType> getByName(String foodName) throws SQLException;

    FoodType getById(int id) throws SQLException;

    int findTotalRecords(String name) throws SQLException;
}
