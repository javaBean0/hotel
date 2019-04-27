package com.bigstone.service.impl;

import com.bigstone.dao.FoodDao;
import com.bigstone.dao.impl.FoodDaoImpl;
import com.bigstone.factory.BeanFactory;
import com.bigstone.service.FoodService;

/**
 * Created with IDEA
 * author:bigStone
 * Date:2019/4/26
 **/
public class FoodServiceImpl implements FoodService{

    private FoodDao foodDao = BeanFactory.getInstance("foodDao", FoodDaoImpl.class);

}
