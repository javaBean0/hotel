package com.bigstone.test.interview;

/**
 * Created with IDEA
 * author: bigStone
 * Date:2019/4/23
 * Time:17:28
 */
public class Example {


    public void test(){

    }


    public static void main(String[] args) {

        String x="fmn";
        x = x.toUpperCase();
        String y=x.replace('f','F');
        y=y+"wxy";
        System.out.println(y);
        System.out.println(Math.cos(Math.toRadians(45)));

    }


}



class TestClass{

    private String username;
    private String password;

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    @Override
    public String toString() {
        return "TestClass{" +
                "username='" + username + '\'' +
                ", password='" + password + '\'' +
                '}';
    }
}

