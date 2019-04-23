package com.bigstone.service;

import com.bigstone.domain.FoodType;

import java.sql.SQLException;
import java.util.List;

/**
 * 菜类模块的业务逻辑层， 接口设计
 * Created with IDEA
 * author: bigStone
 * Date:2019/4/22
 * Time:20:21
 */
public interface IFoodTypeService {

    /**添加*/
    void save(FoodType foodType);

    /**更新*/
    void update(FoodType foodType);

    /**删除*/
    void delete(int id);

    /**根据主键查询*/
    FoodType findById(int id);

    /**查询所有*/
    List<FoodType> getAll();


    /**根据菜系名称查询*/
    List<FoodType> getByName(String foodName);
}
