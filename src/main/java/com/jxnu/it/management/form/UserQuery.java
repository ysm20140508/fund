package com.jxnu.it.management.form;

/**
 * Created by yunva on 2016/1/22.
 */
public class UserQuery {

    private String name;
    private String account;
    private Integer roleId;
    private Integer page;
    private Integer pageSize;
    private String status;

    public String getAccount() {
        return account;
    }

    public void setAccount(String account) {
        this.account = account;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getRoleId() {
        return roleId;
    }

    public void setRoleId(Integer roleId) {
        this.roleId = roleId;
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

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    @Override
    public String toString() {
        return "UserQuery{" +
                "name='" + name + '\'' +
                ", account='" + account + '\'' +
                ", roleId=" + roleId +
                ", page=" + page +
                ", pageSize=" + pageSize +
                ", status=" + status +
                '}';
    }
}
