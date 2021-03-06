package com.bigstone.service.impl;

import com.bigstone.dao.IFoodTypeDao;
import com.bigstone.dao.impl.FoodTypeDaoImpl;
import com.bigstone.domain.FoodType;
import com.bigstone.factory.BeanFactory;
import com.bigstone.service.IFoodTypeService;
import com.bigstone.utils.commons.PageBean;

import java.sql.SQLException;
import java.util.List;

/**
 * 菜类的业务逻辑层接口实现
 * Created with IDEA
 * author: bigStone
 * Date:2019/4/22
 * Time:20:23
 */
public class FoodTypeServiceImpl implements IFoodTypeService {

    private IFoodTypeDao foodTypeDao = BeanFactory.getInstance("foodTypeDao", IFoodTypeDao.class);

    @Override
    public void save(FoodType foodType) {
        try {
            foodTypeDao.save(foodType);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public void update(FoodType foodType) {
        try {
            foodTypeDao.update(foodType);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public void delete(int id) {
        try {
            foodTypeDao.delete(id);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public FoodType findById(int id) {
        try {
            return foodTypeDao.findById(id);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }


    @Override
    public PageBean getAll(String name, Integer num) {
        try {
            int currentPageNum = 1;
            if(num != null){
                currentPageNum = num;
            }
            //获取总条目数
            int totalRecords = foodTypeDao.findTotalRecords(name);
            PageBean pageBean = new PageBean(currentPageNum, totalRecords);
            List<FoodType> foodTypeList = foodTypeDao.getAll(name);
            pageBean.setRecords(foodTypeList);
            return pageBean;
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public List<FoodType> getByName(String foodName) {
        try {
            return foodTypeDao.getByName(foodName);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public FoodType getById(int id) {
        try {
            return foodTypeDao.getById(id);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
}
