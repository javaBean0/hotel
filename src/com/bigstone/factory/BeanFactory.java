package com.bigstone.factory;

import java.util.ResourceBundle;

/**
 * Created with IDEA
 * author: bigStone
 * Date:2019/4/23
 * Time:8:32
 */
public class BeanFactory {

    //加载配置文件
    private static ResourceBundle resourceBundle;

    static {
        resourceBundle = ResourceBundle.getBundle("instance");
    }


    public static <T> T getInstance(String key, Class<T> clazz) {
        String className = resourceBundle.getString(key);
        try {
            return (T) Class.forName(className).newInstance();
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }


}
