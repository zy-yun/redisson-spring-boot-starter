package org.example.redisson;


import org.springframework.boot.context.properties.ConfigurationProperties;


/**
 * redis信息配置类
 * @Author zy
 * @Date 2020/6/29 22:36 PM
 */
@ConfigurationProperties(prefix = "zy.redisson")
public class RedissonProperties {

    private String host = "localhost";
    private int port = 6379;
    private int timeout;
    private boolean ssl;

    public String getHost() {
        return host;
    }

    public void setHost(String host) {
        this.host = host;
    }

    public int getPort() {
        return port;
    }

    public void setPort(int port) {
        this.port = port;
    }

    public int getTimeout() {
        return timeout;
    }

    public void setTimeout(int timeout) {
        this.timeout = timeout;
    }

    public boolean isSsl() {
        return ssl;
    }

    public void setSsl(boolean ssl) {
        this.ssl = ssl;
    }
}
