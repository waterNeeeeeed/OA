package com.runfeng.hibernate;

/**
 * Created by hasee-pc on 2017/4/9.
 */
public class Page {
    private int pageNum;
    private int pageSize;
    private int pageTotal;

    public Page() {
    }

    public int getPageNum() {
        return pageNum;
    }

    public void setPageNum(int pageNum) {
        this.pageNum = pageNum;
    }

    public int getPageSize() {
        return pageSize;
    }

    public void setPageSize(int pageSize) {
        this.pageSize = pageSize;
    }

    public int getPageTotal() {
        return pageTotal;
    }

    public void setPageTotal(int pageTotal) {
        this.pageTotal = pageTotal;
    }
}
