package com.crud.webstore.security;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.stereotype.Component;

@Component
public class AppProperties {
    private Environment environment;

    @Autowired
    public AppProperties() {
    }

    public String getTokenSecret() {
        return environment.getProperty("tokenSecret");
    }
}
