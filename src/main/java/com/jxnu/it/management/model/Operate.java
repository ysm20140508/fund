package com.jxnu.it.management.model;

import org.apache.commons.lang3.builder.ToStringBuilder;

public class Operate {
    private String query = "0";
    private String create = "0";
    private String edit = "0";
    private String delete = "0";

    public String getQuery() {
        return query;
    }

    public void setQuery(String query) {
        this.query = query;
    }

    public String getCreate() {
        return create;
    }

    public void setCreate(String create) {
        this.create = create;
    }

    public String getEdit() {
        return edit;
    }

    public void setEdit(String edit) {
        this.edit = edit;
    }

    public String getDelete() {
        return delete;
    }

    public void setDelete(String delete) {
        this.delete = delete;
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this)
                .append("query", query)
                .append("create", create)
                .append("edit", edit)
                .append("delete", delete)
                .toString();
    }
}
