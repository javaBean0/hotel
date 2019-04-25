package com.bigstone.service.impl;

import com.bigstone.dao.DinnerTableDao;
import com.bigstone.dao.impl.DinnerTableDaoImpl;
import com.bigstone.domain.DinnerTable;
import com.bigstone.factory.BeanFactory;
import com.bigstone.service.DinnerTableService;

import java.sql.SQLException;
import java.util.List;

/**
 * Created with IDEA
 * author:bigStone
 * Date:2019/4/25
 **/
public class DinnerTableServiceImpl implements DinnerTableService {

    private DinnerTableDao dinnerTableDao = BeanFactory.getInstance("dinnerTableDao", DinnerTableDaoImpl.class);

    @Override
    public void save(DinnerTable dinnerTable) {
        try {
            dinnerTableDao.save(dinnerTable);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public void update(DinnerTable dinnerTable){
        try {
            dinnerTableDao.save(dinnerTable);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public void delete(int id){
        try {
            dinnerTableDao.delete(id);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public DinnerTable findById(int id){
        try {
            return dinnerTableDao.findById(id);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public List<DinnerTable> getAll(){
        try {
            return dinnerTableDao.getAll();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
}
