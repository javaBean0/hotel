package com.bigstone.test.interview;

/**
 * Created with IDEA
 * author: bigStone
 * Date:2019/4/23
 * Time:16:37
 */

public class Person extends Example {

    private String username;
    private String password;

    private static int n = 1;

    public static void main(String[] args) {
        int a = Person.n;
        System.out.println(a);
    }

    public Person() {
    }

    public Person(String username, String password) {
        super();
        this.username = username;
        this.password = password;
    }

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

    public void save() {

    }

    public void save(int a) {

    }

}

class A {
    public A() {
        System.out.println("class A");
    }

    {
        System.out.println("I'm A class");
    }

    static {
        System.out.println("class A static");
    }
}

class B extends A {
    public B() {
        System.out.println("class B");
    }

    {
        System.out.println("I'm B class");
    }

    static {
        System.out.println("class B static");
    }

    public static void main(String[] args) {

        new B();
    }

}