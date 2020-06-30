# redisson-spring-boot-starter
自定义一个springboot的 redis starter组件

命名规范：

    组件名字-spring-boot-starter

原生组件命名规范：

    spring-boot-starter-组件名字

一、实现依赖jar包：

    1. springboot依赖
        <dependency>
          <groupId>org.springframework.boot</groupId>
          <artifactId>spring-boot-starter</artifactId>
          <version>2.3.1.RELEASE</version>
          <optional>true</optional>
        </dependency>
    2.redisson依赖
        <dependency>
          <groupId>org.redisson</groupId>
          <artifactId>redisson</artifactId>
          <version>3.13.1</version>
        </dependency>
    3.properties配置类json编译依赖
        <dependency>
          <groupId>org.springframework.boot</groupId>
          <artifactId>spring-boot-configuration-processor</artifactId>
          <version>2.3.1.RELEASE</version>
        </dependency>
    
二、关键类说明 
    
    RedissonProperties.class
    redisson客户端信息配置类：host、port、是否加密，timeout等信息
    注解：
    @ConfigurationProperties(prefix = "zy.redisson")配置文件注解，prefix为配置文件 信息前缀，
    可在被引用应用的.properties文件中 以zy.redisson.host = 192.12.186.21方式配置客户端信息
    
    RedissonConfiguration.class
    RedissonClient客户端生成主类，
    三大注解：
    @ConditionalOnClass(Redisson.class) 条件装配注解，根据classpath中是否存在指定的Redisson类来决定是否启用装配该类
    @EnableConfigurationProperties(RedissonProperties.class) 该注解可将指定的配置类加载到spring的IOC容器中
    @Configuration 配置类注解
    编写@Bean RedissonClient 类

三、然后自己新建一个springboot的应用，引用此redis starter组件
