package com.bigstone.test.singleton;

import org.junit.Test;

/**
 * Created with IDEA
 * author:bigStone
 * Date:2019/4/25
 **/
public class TestSingleton {

    @Test
    public void testSingleton1() throws IllegalAccessException, InstantiationException {
        Singleton s1 = Singleton.getSingleton();
        s1.setUsername("测试数据1");

        Singleton s2 = Singleton.getSingleton();
        s2.setUsername("测试数据2");
        System.out.println(s2.getUsername());
        System.out.println(s1.getUsername());
    }

    @Test
    public void testSingleton2() throws IllegalAccessException, InstantiationException {
        Singleton2 s1 = Singleton2.getSingleton2();
        s1.setUsername("测试数据1");

        Singleton2 s2 = Singleton2.getSingleton2();
        s2.setUsername("测试数据2");
        System.out.println(s2.getUsername());
        System.out.println(s1.getUsername());
    }

}
