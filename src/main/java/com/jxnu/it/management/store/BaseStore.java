package com.jxnu.it.management.store;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;

public abstract class BaseStore {
    @Autowired
    protected SqlSessionTemplate template;

    public SqlSessionTemplate getTemplate() {
        return template;
    }
}
