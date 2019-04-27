package com.bigstone.factory;

import org.junit.Test;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;
/**
 * Created with IDEA
 * author:bigStone
 * Date:2019/4/27
 **/
public class DefaultParams {



//根据参数读取
    public static String getDefaultParams(String param){

        try {
            InputStream resourceAsStream = DefaultParams.class.getClassLoader().getResourceAsStream("default.properties");
            Properties properties = new Properties();
            properties.load(resourceAsStream);
            return properties.getProperty(param);
        } catch (IOException e) {
            throw new RuntimeException("获取默认参数异常！");
        }

    }


    @Test
    public void test(){
        String pageSize = getDefaultParams("pageSize");
        System.out.println(pageSize);
    }


}
