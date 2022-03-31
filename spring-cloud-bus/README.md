# 工程简介
Spring Cloud Steam & Bus Demo

本demo通过集成Spring Cloud Stream和Spring Cloud Bus实现事件的发送和接受


## 部署过程

### 1、kafka、nacos部署

### spring-cloud-bus-common

* dependency
````xml
 <dependency>
            <groupId>org.springframework.boot</groupId>
            <artifactId>spring-boot-starter-web</artifactId>
        </dependency>
        <dependency>
            <groupId>org.springframework.cloud</groupId>
            <artifactId>spring-cloud-bus</artifactId>
            <version>2.2.0.RELEASE</version>
        </dependency>
        <dependency>
            <groupId>com.alibaba.cloud</groupId>
            <artifactId>spring-cloud-starter-alibaba-nacos-discovery</artifactId>
        </dependency>
        <dependency>
            <groupId>com.alibaba.cloud</groupId>
            <artifactId>spring-cloud-starter-alibaba-nacos-config</artifactId>
        </dependency>
        <!-- 依赖 Spring Cloud Stream Binder Kafka -->
        <dependency>
            <groupId>org.springframework.cloud</groupId>
            <artifactId>spring-cloud-stream-binder-kafka</artifactId>
        </dependency>
        <dependency>
            <groupId>org.springframework.cloud</groupId>
            <artifactId>spring-cloud-starter-stream-kafka</artifactId>
        </dependency>
        <dependency>
            <groupId>org.springframework.cloud</groupId>
            <artifactId>spring-cloud-starter-bus-kafka</artifactId>
        </dependency>
        <dependency>
            <groupId>org.springframework.boot</groupId>
            <artifactId>spring-boot-starter-actuator</artifactId>
        </dependency>
        <dependency>
            <groupId>org.projectlombok</groupId>
            <artifactId>lombok</artifactId>
        </dependency>
````
* 创建Event SelfRemoteApplicationEvent

### 2、spring-cloud-bus-provider
从服务角度来讲，是provider，从kafka角度来看，是consumer， 消费kafka消息。

* dependency
````xml
 <dependency>
    <groupId>com.wenxuezheng.study.bus.common</groupId>
    <artifactId>spring-cloud-bus-common</artifactId>
    <version>0.0.1-SNAPSHOT</version>
</dependency>
````

* bootstrap.properties
用于配置nacos
````properties
config.nacos.host=127.0.0.1
config.nacos.port=8848
config.nacos.namespace=test
config.nacos.group=test
config.nacos.username=nacos
config.nacos.password=nacos
################################################## 以下配置不要随意改动 ###################################################
# nacos config server
spring.cloud.nacos.config.server-addr=${config.nacos.host}:${config.nacos.port}
spring.cloud.nacos.config.namespace=${config.nacos.namespace}
spring.cloud.nacos.config.group=${config.nacos.group}
spring.cloud.nacos.config.username=${config.nacos.username}
spring.cloud.nacos.config.password=${config.nacos.password}
````

* application.properties
````properties
# nacos discovery
spring.cloud.nacos.discovery.server-addr=${config.nacos.host}:${config.nacos.port}
spring.cloud.nacos.discovery.namespace=${config.nacos.namespace}
spring.cloud.nacos.discovery.group=${config.nacos.group}

# 应用名称
spring.application.name=spring-cloud-bus-provider
server.port=0

spring.cloud.stream.bindings.input.destination=users
spring.cloud.stream.bindings.input.content-type=text/plain
spring.cloud.stream.bindings.input.group=users
spring.cloud.stream.kafka.binder.brokers=kafka.local1.etcc.group

# 作为kafka消费端, 可以通过这两个设置指定group， 需要与发送方的spring.cloud.stream.default.group参数一致
spring.cloud.stream.bindings.springCloudBusTest.destination=springCloudBusTest
spring.cloud.stream.bindings.springCloudBusTest.group=group3
#spring.cloud.stream.default.group=group3
# 作为kafka消费端, 此destination即为kafka的topic
spring.cloud.bus.destination=springCloudBusTest
# 作为kafka消费端, 此id作为发送方的destination
spring.cloud.bus.id=springCloudBusProvider
````

* 创建事件监听 SelfBusConfiguration



### spring-cloud-bus-consumer
从服务角度来讲，是consumer，从kafka角度来看，是provider, 向kafka发送消息。

* dependency 同上
* bootstrap.properties 同上
* application.properties
````properties

# nacos discovery
spring.cloud.nacos.discovery.server-addr=${config.nacos.host}:${config.nacos.port}
spring.cloud.nacos.discovery.namespace=${config.nacos.namespace}
spring.cloud.nacos.discovery.group=${config.nacos.group}

# 应用名称
spring.application.name=spring-cloud-bus-consumer
server.port=8082

spring.cloud.stream.bindings.output.destination=users
spring.cloud.stream.bindings.output.content-type=text/plain
spring.cloud.stream.bindings.output.group=users
spring.cloud.stream.kafka.binder.brokers=kafka.local1.etcc.group

# 作为kafka消息发送方,要是用此配置修改group
spring.cloud.stream.default.group=group3

spring.cloud.bus.destination=springCloudBusTest
spring.cloud.bus.id=springCloudBusConsumer
````

* 模拟事件生成 SelfBusController

destination: 事件接受方的spring.cloud.bus.id
只要把需要发送的事件对象SelfRemoteApplicationEvent通过ApplicationEventPublisher发送出去即可
````java
    applicationEventPublisher.publishEvent(selfRemoteApplicationEvent);
````


在postman中请求`http://127.0.0.1:8082/bus/self/publish/springCloudBusProvider/testEvent`