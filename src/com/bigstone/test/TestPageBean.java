package com.bigstone.test;

import com.bigstone.factory.BeanFactory;
import com.bigstone.service.impl.FoodTypeServiceImpl;
import com.bigstone.utils.commons.PageBean;
import org.junit.Test;

import java.util.List;

/**
 * Created with IDEA
 * author:bigStone
 * Date:2019/4/27
 **/
public class TestPageBean {

    @Test
    public void test(){
        FoodTypeServiceImpl foodTypeService = BeanFactory.getInstance("foodTypeService", FoodTypeServiceImpl.class);
        PageBean pageBean = foodTypeService.getAll("上海", 1);

        List records = pageBean.getRecords();
        for (int i = 0; i <records.size() ; i++) {
            System.out.println(records.get(i).toString());

        }
    }



}
