package com.bigstone.test;

import com.bigstone.domain.FoodType;
import com.bigstone.factory.BeanFactory;
import com.bigstone.service.IFoodTypeService;
import com.sun.xml.internal.bind.v2.runtime.unmarshaller.XsiNilLoader;
import org.junit.Test;

import java.util.List;
import java.util.ResourceBundle;

/**
 * Created with IDEA
 * author: bigStone
 * Date:2019/4/23
 * Time:8:34
 */
public abstract class testResourceBundle {
    private IFoodTypeService foodTypeService = BeanFactory.getInstance("foodTypeService", IFoodTypeService.class);
   //@Test
   /* public void testResourceBundle() {
        List<FoodType> foodTypeList = foodTypeService.getAll();
        for (int i = 0; i < foodTypeList.size(); i++) {
            FoodType foodType = foodTypeList.get(i);
            System.out.println(foodType);
        }
    }*/







}
