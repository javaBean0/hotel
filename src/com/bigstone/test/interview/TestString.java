package com.bigstone.test.interview;

import org.junit.Test;

/**
 * Created with IDEA
 * author:bigStone
 * Date:2019/4/26
 **/
public class TestString {



    @Test
    public void TestString(){
        Object o=new Object(){
            public boolean equals(Object obj){
                return true;
            }
        };
        System.out.println(o.equals("abc"));
    }

}
