package com.bigstone.test.singleton;

/**
 * 饿汉式，不支持lazy-load
 * Created with IDEA
 * author:bigStone
 * Date:2019/4/25
 **/
public class Singleton {

    private static final Singleton singleton = new Singleton();
    private String username;
    private int sum;

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public int getSum() {
        return sum;
    }

    public void setSum(int sum) {
        this.sum = sum;
    }

    private Singleton(){

    }


    public static Singleton getSingleton(){
        return singleton;
    }
}

/**
 * 静态内部类实现单例模式（推荐使用）
 */
class Singleton2 {

    private Singleton2(){
    }

    private String username;


    public static class SingletonInstance{
        private static final Singleton2 SINGLETON_2 = new Singleton2();
    }

    public static Singleton2 getSingleton2(){
        return SingletonInstance.SINGLETON_2;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }
}
