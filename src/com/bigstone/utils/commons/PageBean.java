package com.bigstone.utils.commons;

/**
 * 用于封装分页数据的对象
 * Created with IDEA
 * author:bigStone
 * Date:2019/4/27
 **/

import com.bigstone.factory.DefaultParams;

import java.io.Serializable;
import java.util.List;

public class PageBean implements Serializable {

    private int currentPageNum;//当前页				*
    private int pageSize = Integer.parseInt(DefaultParams.getDefaultParams("pageSize"));//每页显示的条数			*
    private int totalRecords;//总记录条数				*
    private int startIndex;//查询的开始记录索引			*
    private int totalPageNum;//总页数					*
    private int prePageNum;//上一页					*
    private int nextPageNum;//下一页					*
    private List records;//分好页的结果集（最多只能有5个对象）

    //用于显示页码的属性。我们的需求就是页面上最多只显示9个页码。当前页在允许的情况下永远居中
    private int beginPageNum;
    private int endPageNum;

    /**
     * 要想使用此类，必须提供2个参数
     * @param currentPageNum	当前页
     * @param totalRecords		总记录条数
     */
    public PageBean(int currentPageNum, int totalRecords){
        this.currentPageNum = currentPageNum;
        this.totalRecords = totalRecords;

        //计算开始记录索引
        startIndex = (currentPageNum - 1) * pageSize;

        //计算总页数
        totalPageNum = totalRecords%pageSize==0 ? totalRecords/pageSize : totalRecords/pageSize+1;

        //计算页号
        if(totalPageNum < 9){
            beginPageNum = 1;
            endPageNum = totalPageNum;
        }else{
            beginPageNum = currentPageNum - 4;
            endPageNum = currentPageNum + 4;
            if(beginPageNum < 1){
                beginPageNum = 1;
                endPageNum = beginPageNum + 8;
            }
            if(endPageNum > totalPageNum){
                endPageNum = totalPageNum;
                beginPageNum = endPageNum - 8;
            }
        }
    }

    public int getPrePageNum() {
        //计算上一页
        prePageNum = currentPageNum - 1;
        if(prePageNum < 1){
            prePageNum = 1;
        }
        return prePageNum;
    }

    public int getNextPageNum() {
        //计算下一页
        nextPageNum = currentPageNum + 1;
        if(nextPageNum > totalPageNum){
            nextPageNum = totalPageNum;
        }
        return nextPageNum;
    }

    public int getCurrentPageNum() {
        return currentPageNum;
    }

    public void setCurrentPageNum(int currentPageNum) {
        this.currentPageNum = currentPageNum;
    }

    public int getPageSize() {
        return pageSize;
    }

    public void setPageSize(int pageSize) {
        this.pageSize = pageSize;
    }

    public int getTotalRecords() {
        return totalRecords;
    }

    public void setTotalRecords(int totalRecords) {
        this.totalRecords = totalRecords;
    }

    public int getStartIndex() {
        return startIndex;
    }

    public void setStartIndex(int startIndex) {
        this.startIndex = startIndex;
    }

    public int getTotalPageNum() {
        return totalPageNum;
    }

    public void setTotalPageNum(int totalPageNum) {
        this.totalPageNum = totalPageNum;
    }

    public List getRecords() {
        return records;
    }

    public void setRecords(List records) {
        this.records = records;
    }

    public void setPrePageNum(int prePageNum) {
        this.prePageNum = prePageNum;
    }

    public void setNextPageNum(int nextPageNum) {
        this.nextPageNum = nextPageNum;
    }

    public int getBeginPageNum() {
        return beginPageNum;
    }

    public void setBeginPageNum(int beginPageNum) {
        this.beginPageNum = beginPageNum;
    }

    public int getEndPageNum() {
        return endPageNum;
    }

    public void setEndPageNum(int endPageNum) {
        this.endPageNum = endPageNum;
    }


}
