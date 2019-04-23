package com.bigstone.test;

import org.junit.Test;
import java.util.ResourceBundle;
/**
 * Created with IDEA
 * author: bigStone
 * Date:2019/4/23
 * Time:8:34
 */
public class testResourceBundle {
    //加载配置文件
    private static ResourceBundle resourceBundle;

    @Test
    public void testResourceBundle(){
        resourceBundle = ResourceBundle.getBundle("instance");
        System.out.println(resourceBundle.getString("foodTypeDao"));;
    }

}
