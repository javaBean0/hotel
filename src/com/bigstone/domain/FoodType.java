package com.bigstone.domain;

/**
 * Created with IDEA
 * author: bigStone
 * Date:2019/4/22
 * Time:18:55
 */
public class FoodType {

    private int id;
    private String typeName;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTypeName() {
        return typeName;
    }

    public void setTypeName(String typeName) {
        this.typeName = typeName;
    }

    @Override
    public String toString() {
        return "FoodType{" +
                "id=" + id +
                ", typeName='" + typeName + '\'' +
                '}';
    }
}
