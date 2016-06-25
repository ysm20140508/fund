package com.jxnu.it.management.form;

import org.apache.commons.lang3.builder.ToStringBuilder;

public class SmsSpResourceInfoQuery {
    private String smsSpId;
    private Integer page;
    private Integer pageSize;

    public String getSmsSpId() {
        return smsSpId;
    }

    public void setSmsSpId(String smsSpId) {
        this.smsSpId = smsSpId;
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
                .append("smsSpId", smsSpId)
                .append("page", page)
                .append("pageSize", pageSize)
                .toString();
    }
}
