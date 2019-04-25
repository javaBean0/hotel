package com.bigstone.dao.impl;

import com.bigstone.dao.DinnerTableDao;
import com.bigstone.domain.DinnerTable;
import com.bigstone.domain.FoodType;
import com.bigstone.utils.JdbcUtils;

import java.sql.SQLException;
import java.util.List;

/**
 * Created with IDEA
 * author:bigStone
 * Date:2019/4/25
 **/
public class DinnerTableDaoImpl implements DinnerTableDao {

    @Override
    public void save(DinnerTable dinnerTable) throws SQLException {
        String sql = "INSERT INTO dinnertable(tableName, tableState, orderDate) VALUES(?, ?, ?)";
        Object [] pararms = new Object[]{dinnerTable.getTableName(), dinnerTable.getTableState(), dinnerTable.getOrderDate()};
        JdbcUtils.getQueryRunner().update(sql, pararms);
    }

    @Override
    public void update(DinnerTable dinnerTable) throws SQLException {
        String sql = "UPDATE dinnertable SET tableName = ?, tableState = ?" +
                "orderTime = ? WHERE id = ?";
        Object [] params = new Object[]{dinnerTable.getTableName(), dinnerTable.getTableState(), dinnerTable.getOrderDate(), dinnerTable.getId()};
        JdbcUtils.getQueryRunner().update(sql, params);
    }

    @Override
    public void delete(int id) throws SQLException {

    }

    @Override
    public FoodType findById(int id) throws SQLException {
        return null;
    }

    @Override
    public List<FoodType> getAll() throws SQLException {
        return null;
    }
}
