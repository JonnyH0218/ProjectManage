package com.jhun.entity;

import java.util.List;

public class PageBean<T> {
    // 当前页
    private Integer page = 1;
    // 每页显示的总条数
    private Integer rows = 20;
    // 总条数
    private Integer totalNum;
    // 总页数
    private Integer totalPage;
    // 分页结果
    private List<T> items;

    public PageBean(Integer page, Integer rows) {
        this.page = page;
        this.rows = rows;
    }

    public void setPage(Integer page) {
        this.page = page;
    }

    public void setRows(Integer rows) {
        this.rows = rows;
    }

    public void setTotalNum(Integer totalNum) {
        this.totalNum = totalNum;
    }

    public void setTotalPage(Integer totalPage) {
        this.totalPage = totalPage;
    }

    public void setItems(List<T> items) {
        this.items = items;
    }

    public Integer getPage() {
        return page;
    }

    public Integer getRows() {
        return rows;
    }

    public Integer getTotalNum() {
        return totalNum;
    }

    public Integer getTotalPage() {
        return totalPage;
    }

    public List<T> getItems() {
        return items;
    }
}
