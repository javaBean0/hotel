package com.bigstone.dao;

import com.bigstone.domain.Food;

import java.sql.SQLException;
import java.util.List;

/**
 * Created with IDEA
 * author:bigStone
 * Date:2019/4/26
 **/
public interface FoodDao {

    void save(Food food) throws SQLException;

    Food getById(Food food) throws SQLException;

    void delete(Food food) throws SQLException;

    void update(Food foof) throws SQLException;

    List<Food> getByName(String foodName) throws SQLException;

    List<Food> getAll() throws SQLException;

}
