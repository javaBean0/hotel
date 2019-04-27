package com.bigstone.web.servlet;

import com.bigstone.factory.BeanFactory;
import com.bigstone.service.FoodService;
import com.bigstone.service.impl.FoodServiceImpl;
import com.bigstone.utils.servlet.BaseServlet;

import java.awt.image.BandCombineOp;

/**
 * 菜品servlet层
 * Created with IDEA
 * author:bigStone
 * Date:2019/4/26
 **/
public class FoodServlet extends BaseServlet {

    private FoodService foodService = BeanFactory.getInstance("foodService", FoodServiceImpl.class);



}
