package com.bigstone.dao.impl;

import com.bigstone.dao.IFoodTypeDao;
import com.bigstone.domain.FoodType;
import com.bigstone.utils.jdbc.TxQueryRunner;
import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanHandler;
import org.apache.commons.dbutils.handlers.BeanListHandler;
import org.apache.commons.dbutils.handlers.ScalarHandler;

import java.sql.SQLException;
import java.util.List;

/**
 * 餐桌管理dao层实现类
 * Created with IDEA
 * author: bigStone
 * Date:2019/4/22
 * Time:19:07
 */
public class FoodTypeDaoImpl implements IFoodTypeDao {

    private QueryRunner qr = new TxQueryRunner();

    @Override
    public void save(FoodType foodType) throws SQLException {
        String sql = "INSERT INTO foodType(typeName) VALUES(?)";
        qr.update(sql, foodType.getTypeName());

    }

    @Override
    public void update(FoodType foodType) throws SQLException {
        String sql = "UPDATE foodType SET typeName = ? WHERE id = ?";
        Object[] params = {foodType.getTypeName(), foodType.getId()};
        qr.update(sql, params);
    }

    @Override
    public void delete(int id) throws SQLException {
        String sql = "DELETE FROM foodType WHERE id = ?";
        qr.update(sql, id);
    }

    @Override
    public FoodType findById(int id) throws SQLException {
        String sql = "SELECT * FROM foodType WHERE id = ?";
        return qr.query(sql, new BeanHandler<FoodType>(FoodType.class), id);
    }

    @Override
    public List<FoodType> getAll(String name) throws SQLException {
       if(name == null){
           String sql = "SELECT * FROM foodType";
           return qr.query(sql, new BeanListHandler<FoodType>(FoodType.class));
       }else{
           String sql = "SELECT * FROM foodType WHERE typeName LIKE ?";
           return qr.query(sql, new BeanListHandler<FoodType>(FoodType.class), "%" + name + "%");
       }
    }

    @Override
    public List<FoodType> getByName(String foodName) throws SQLException {
        String sql = "SELECT * FROM foodType where typeName like ?";
        return qr.query(sql,
                new BeanListHandler<FoodType>(FoodType.class), "%" + foodName + "%");
    }

    @Override
    public FoodType getById(int id) throws SQLException {
        String sql = "SELECT * FROM foodType WHERE id = ?";
        return qr.query(sql, new BeanHandler<FoodType>(FoodType.class), id);
    }

    @Override
    public int findTotalRecords(String name) throws SQLException {
        String sql = "SELECT count(*) FROM foodType";
        Number result = null;
        if(name == null){
            result =  qr.query(sql, new ScalarHandler<>());
        }else{
            sql = "SELECT count(*) FROM foodType WHERE typeName LIke ?";
            result = qr.query(sql, new ScalarHandler<>(), "%" + name + "%");
        }
        return result.intValue();//得到总记录数
    }
}
