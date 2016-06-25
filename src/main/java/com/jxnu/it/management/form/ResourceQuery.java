package com.jxnu.it.management.form;

import org.apache.commons.lang3.builder.ToStringBuilder;

public class ResourceQuery {
    private String name;
    private Integer parentId;
    private Integer page;
    private Integer pageSize;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getParentId() {
        return parentId;
    }

    public void setParentId(Integer parentId) {
        this.parentId = parentId;
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
                .append("name", name)
                .append("parentId", parentId)
                .append("page", page)
                .append("pageSize", pageSize)
                .toString();
    }
}
