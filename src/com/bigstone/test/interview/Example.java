package com.bigstone.test.interview;

/**
 * Created with IDEA
 * author: bigStone
 * Date:2019/4/23
 * Time:17:28
 */
public class Example {

    public static void main(String[] args) {

        TestClass person = new TestClass();
        person.setUsername("zhangsan ");
        person.setPassword("lisl");
        System.out.println(person);

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

