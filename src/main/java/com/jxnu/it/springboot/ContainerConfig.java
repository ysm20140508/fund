package com.jxnu.it.springboot;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component
public class ContainerConfig {
    @Value("${container.port}")
    private int port;
    @Value("${container.address}")
    private String address;
    @Value("${container.session.timeout.seconds}")
    private int sessionTimeoutSeconds;

    public int getPort() {
        return port;
    }

    public void setPort(int port) {
        this.port = port;
    }

    public int getSessionTimeoutSeconds() {
        return sessionTimeoutSeconds;
    }

    public void setSessionTimeoutSeconds(int sessionTimeoutSeconds) {
        this.sessionTimeoutSeconds = sessionTimeoutSeconds;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    @Override
    public String toString() {
        return new org.apache.commons.lang3.builder.ToStringBuilder(this)
                .append("port", port)
                .append("address", address)
                .append("sessionTimeoutSeconds", sessionTimeoutSeconds)
                .toString();
    }
}
