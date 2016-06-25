package com.jxnu.it.management.form;

import org.apache.commons.lang3.builder.ToStringBuilder;

public class SmsProviderQuery {
    private Integer id;
    private String companyName;
    private String status;
    private Integer userId;
    private Integer page;
    private Integer pageSize;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getCompanyName() {
        return companyName;
    }

    public void setCompanyName(String companyName) {
        this.companyName = companyName;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    public Integer getPage() {
        return page;
    }

    public void setPage(Integer page) {
        this.page = page;
    }

    public Integer getPageSize() {
        return pageSize;
    }

    public void setPageSize(Integer pageSize) {
        this.pageSize = pageSize;
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this)
                .append("id", id)
                .append("companyName", companyName)
                .append("status", status)
                .append("userId", userId)
                .append("page", page)
                .append("pageSize", pageSize)
                .toString();
    }
}
