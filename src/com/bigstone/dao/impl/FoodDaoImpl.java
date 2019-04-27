package com.bigstone.dao.impl;

import com.bigstone.dao.FoodDao;
import com.bigstone.domain.Food;
import com.bigstone.utils.jdbc.TxQueryRunner;
import org.apache.commons.dbutils.QueryRunner;

import java.sql.SQLException;
import java.util.List;

/**
 * Created with IDEA
 * author:bigStone
 * Date:2019/4/26
 **/
public class FoodDaoImpl implements FoodDao{

    private QueryRunner qr = new TxQueryRunner();

    @Override
    public void save(Food food) throws SQLException {
        String sql = "INSERT INTO food(" +
                "foodName, foodType_id, price, mprice, remark, img)" +
                " VALUES(?,? ,? ,? ,? ,?)";
        Object[] params = new Object[]{food.getFoodName(), food.getFoodType().getId(),
                        food.getPrice(), food.getMprice(), food.getImg()};
        qr.update(sql, params);

    }

    @Override
    public Food getById(Food food) throws SQLException {
        String sql = "";
        return null;
    }

    @Override
    public void delete(Food food) throws SQLException{

    }

    @Override
    public void update(Food foof) throws SQLException{

    }

    @Override
    public List<Food> getByName(String foodName)throws SQLException {
        return null;
    }

    @Override
    public List<Food> getAll() throws SQLException {
        return null;
    }
}
