package com.jxnu.it.springboot;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.context.embedded.ConfigurableEmbeddedServletContainer;
import org.springframework.boot.context.embedded.EmbeddedServletContainerCustomizer;
import org.springframework.stereotype.Component;

import java.util.concurrent.TimeUnit;

@Component
public class ContainerCustomizer implements EmbeddedServletContainerCustomizer {
    private final Logger logger = LoggerFactory.getLogger(getClass());
    @Autowired
    private ContainerConfig containerConfig;

    @Override
    public void customize(ConfigurableEmbeddedServletContainer configurableEmbeddedServletContainer) {
        configurableEmbeddedServletContainer.setPort(containerConfig.getPort());

//        InetAddress inetAddress = null;
//        try {
//            inetAddress = InetAddress.getByAddress(IPUtil.ipv4Address2BinaryArray(containerConfig.getAddress()));
//        } catch (UnknownHostException e) {
//            logger.error("Container Address Config Error.config:{}", containerConfig);
//            throw new RuntimeException("Container Address Config Error.");
//        }
//        configurableEmbeddedServletContainer.setAddress(inetAddress);
        configurableEmbeddedServletContainer.setSessionTimeout(containerConfig.getSessionTimeoutSeconds(), TimeUnit.SECONDS);

    }
}
