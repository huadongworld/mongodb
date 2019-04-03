package com.ys.mongodb.spring.data.mongodb.config;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

/**
 * @author HuaDong
 * @date 2019/4/3 14:02
 */
@Component
@ConfigurationProperties(prefix = "spring.data.mongodb")
public class MongoDbProperties {

    private String host;

    private String database;

    private Integer port;

    public Integer getPort() {
        return port;
    }

    public void setPort(Integer port) {
        this.port = port;
    }

    public String getHost() {
        return host;
    }

    public void setHost(String host) {
        this.host = host;
    }

    public String getDatabase() {
        return database;
    }

    public void setDatabase(String database) {
        this.database = database;
    }
}
