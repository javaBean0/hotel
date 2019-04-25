package com.bigstone.domain;

import java.io.Serializable;
import java.util.Date;

/**
 * 餐桌的实体类
 * Created with IDEA
 * author:bigStone
 * Date:2019/4/25
 **/
public class DinnerTable implements Serializable {

    private int id;
    private String tableName;
    private int tableState;
    private Date orderDate;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTableName() {
        return tableName;
    }

    public void setTableName(String tableName) {
        this.tableName = tableName;
    }

    public int getTableState() {
        return tableState;
    }

    public void setTableState(int tableState) {
        this.tableState = tableState;
    }

    public Date getOrderDate() {
        return orderDate;
    }

    public void setOrderDate(Date orderDate) {
        this.orderDate = orderDate;
    }
}
