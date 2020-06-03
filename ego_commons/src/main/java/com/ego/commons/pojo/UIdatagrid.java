package com.ego.commons.pojo;

import java.util.List;

/**
 * 分页查询 页面模版
 */
public class UIdatagrid {

    private List<?> rows;

    private long total;



    public UIdatagrid() {
    }

    public UIdatagrid(List<?> rows,long total) {
        this.total = total;
        this.rows = rows;
    }

    public long getTotal() {
        return total;
    }

    public void setTotal(long total) {
        this.total = total;
    }

    public List<?> getRows() {
        return rows;
    }

    public void setRows(List<?> rows) {
        this.rows = rows;
    }
}
