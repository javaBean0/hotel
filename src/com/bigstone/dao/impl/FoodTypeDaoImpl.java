package com.bigstone.dao.impl;

import com.bigstone.dao.IFoodTypeDao;
import com.bigstone.domain.FoodType;
import com.bigstone.utils.JdbcUtils;
import org.apache.commons.dbutils.handlers.BeanHandler;
import org.apache.commons.dbutils.handlers.BeanListHandler;

import java.sql.SQLException;
import java.util.List;

/**
 * Created with IDEA
 * author: bigStone
 * Date:2019/4/22
 * Time:19:07
 */
public class FoodTypeDaoImpl implements IFoodTypeDao {
    @Override
    public void save(FoodType foodType) throws SQLException {
        String sql = "INSERT INTO foodType(typeName) values(?)";
        JdbcUtils.getQueryRunner().update(sql, foodType.getTypeName());
    }

    @Override
    public void update(FoodType foodType) throws SQLException {
        String sql = "UPDATE foodType SET typeName = ? WHERE id = ?";
        Object[] params = {foodType.getTypeName(), foodType.getId()};
        JdbcUtils.getQueryRunner().update(sql, params);
    }

    @Override
    public void delete(int id) throws SQLException {
        String sql = "DELETE FROM foodType WHERE id = ?";
        JdbcUtils.getQueryRunner().update(sql, id);
    }

    @Override
    public FoodType findById(int id) throws SQLException {
        String sql = "SELECT * FROM foodType WHERE id = ?";
        return JdbcUtils.getQueryRunner().query(sql, new BeanHandler<FoodType>(FoodType.class), id);
    }

    @Override
    public List<FoodType> getAll() throws SQLException {
        String sql = "SELECT * FROM foodType";
        return JdbcUtils.getQueryRunner().query(sql, new BeanListHandler<FoodType>(FoodType.class));
    }

    @Override
    public List<FoodType> getByName(String foodName) throws SQLException {
        String sql = "SELECT * FROM foodType where typeName like ?";
        return JdbcUtils.getQueryRunner().query(sql,
                new BeanListHandler<FoodType>(FoodType.class), "%" + foodName + "%");
    }
}
