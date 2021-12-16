package com.detection.entity;

import java.util.HashMap;
import java.util.List;

/**
 * @author ding
 * @date 2021/12/8
 */
public class Pager{
    private int page;//分页起始页
    private int size;//每页记录数
    private List<?> rows;//返回的记录集合
    private long total;//总记录条数
    public int getPage() {
        return page;
    }
    public void setPage(int page) {
        this.page = page;
    }
    public int getSize() {
        return size;
    }
    public void setSize(int size) {
        this.size = size;
    }
    public List<?> getRows() {
        return rows;
    }
    public void setRows(List<?> rows) {
        this.rows = rows;
    }

    public long getTotal() {
        return total;
    }
    public void setTotal(long total) {
        this.total = total;
    }

}
