package org.example.redisson;


import org.redisson.Redisson;
import org.redisson.api.RedissonClient;
import org.redisson.config.Config;
import org.redisson.config.SingleServerConfig;
import org.springframework.boot.autoconfigure.condition.ConditionalOnClass;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * redissonClient 客户端生成配置类
 * @ConditionalOnClass 该注解为条件装配，只有在classpath中存在指定的类时，才装载该类
 * @EnableConfigurationProperties 该注解可将制定的配置类加载到spring的IOC容器中
 * @Author zy
 * @Date 2020/6/29 21:48 PM
 */
@ConditionalOnClass(Redisson.class)
@EnableConfigurationProperties(RedissonProperties.class)
@Configuration
public class RedissonConfiguration {

    @Bean
    RedissonClient redissonClient(RedissonProperties redissonProperties){
        Config config = new Config();
        //前缀，固定
        String prefix = "redis://";

        //判断是否是加密请求
        if (redissonProperties.isSsl()){
            prefix = "rediss://";
        }
        SingleServerConfig serverConfig = config.useSingleServer().setAddress(prefix+redissonProperties.getHost()+":"+redissonProperties.getPort())
                .setConnectTimeout(redissonProperties.getTimeout());

        //建造者模式
        return Redisson.create(config);
    }
}
