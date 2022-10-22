package com.acspace.response;

import java.util.List;

/**
 * 分页结果类
 */
public class PageResponse<T> {

    private Long total;//总记录数
    private List<T> rows;//记录

    public PageResponse(Long total, List<T> rows) {
        this.total = total;
        this.rows = rows;
    }

    public PageResponse() {
    }

    public Long getTotal() {
        return total;
    }

    public void setTotal(Long total) {
        this.total = total;
    }

    public List<T> getRows() {
        return rows;
    }

    public void setRows(List<T> rows) {
        this.rows = rows;
    }
}
