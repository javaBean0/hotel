package com.bigstone.dao.impl;

import com.bigstone.dao.DinnerTableDao;
import com.bigstone.domain.DinnerTable;
import com.bigstone.utils.jdbc.TxQueryRunner;
import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanHandler;
import org.apache.commons.dbutils.handlers.BeanListHandler;

import java.sql.SQLException;
import java.util.List;

/**
 * Created with IDEA
 * author:bigStone
 * Date:2019/4/25
 **/
public class DinnerTableDaoImpl implements DinnerTableDao {

    private QueryRunner qr = new TxQueryRunner();

    @Override
    public void save(DinnerTable dinnerTable) throws SQLException {
        String sql = "INSERT INTO dinnertable(tableName, tableStatus, orderDate) VALUES(?, ?, ?)";
        Object [] pararms = new Object[]{dinnerTable.getTableName(), dinnerTable.getTableStatus(), dinnerTable.getOrderDate()};
        qr.update(sql, pararms);
    }

    @Override
    public void update(DinnerTable dinnerTable) throws SQLException {
        String sql = "UPDATE dinnertable SET tableName = ?, tableStatus = ?" +
                "orderTime = ? WHERE id = ?";
        Object [] params = new Object[]{dinnerTable.getTableName(), dinnerTable.getTableStatus(),
                dinnerTable.getOrderDate(), dinnerTable.getId()};
        qr.update(sql, params);
    }

    @Override
    public void delete(int id) throws SQLException {
        String sql = "DELETE FROM dinnertable WHERE id = ?";
        qr.update(sql, id);
    }

    @Override
    public DinnerTable findById(int id) throws SQLException {
        String sql = "SELECT * FROM dinnertable WHERE id = ?";
        return qr.query(sql,new BeanHandler<DinnerTable>(DinnerTable.class),id);
    }

    @Override
    public List<DinnerTable> getAll() throws SQLException {
        String sql = "SELECT * FROM dinnertable";
        return qr.query(sql, new BeanListHandler<DinnerTable>(DinnerTable.class));
    }
}
