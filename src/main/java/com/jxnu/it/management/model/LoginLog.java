package com.jxnu.it.management.model;

import org.apache.commons.lang3.builder.ToStringBuilder;

public class LoginLog {
    private Integer userId;
    private String userAgent;
    private String ip;

    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    public String getUserAgent() {
        return userAgent;
    }

    public void setUserAgent(String userAgent) {
        this.userAgent = userAgent;
    }

    public String getIp() {
        return ip;
    }

    public void setIp(String ip) {
        this.ip = ip;
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this)
                .append("userId", userId)
                .append("userAgent", userAgent)
                .append("ip", ip)
                .toString();
    }
}
