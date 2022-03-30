# Spring Boot 调用 MinIO

## MinIO

### minIO介绍

* 官网: https://min.io/

### 使用Docker搭建MinIO

````shell
docker run -p 9000:9000 -p 9001:9001 \
  --name minio1 \
  -v /opt/data:/data \
  -e "MINIO_ROOT_USER=AKIAIOSFODNN7EXAMPLE" \
  -e "MINIO_ROOT_PASSWORD=wJalrXUtnFEMI/K7MDENG/bPxRfiCYEXAMPLEKEY" \
  minio/minio server /data --console-address ":9001"
````

启动之后就可以访问localhost:9000,访问控制台, 用户名和密码即为MINIO_ROOT_USER/MINIO_ROOT_PASSWORD
登录后需要创建一个bucket


## Spring Boot

### 依赖
````xml
    <dependency>
        <groupId>org.springframework.boot</groupId>
        <artifactId>spring-boot-starter-web</artifactId>
    </dependency>
    <!-- thymeleaf模板渲染引擎-->
    <dependency>
        <groupId>org.springframework.boot</groupId>
        <artifactId>spring-boot-starter-thymeleaf</artifactId>
    </dependency>
    <!-- 操作minio的java客户端-->
    <dependency>
        <groupId>io.minio</groupId>
        <artifactId>minio</artifactId>
        <version>8.3.7</version>
    </dependency>
    <!-- lombok插件-->
    <dependency>
        <groupId>org.projectlombok</groupId>
        <artifactId>lombok</artifactId>
        <optional>true</optional>
    </dependency>
````

### 配置application.properties

````properties
spring.servlet.multipart.max-file-size=10MB
spring.servlet.multipart.max-request-size=10MB
#minio配置
spring.minio.access-key=AKIAIOSFODNN7EXAMPLE
#key就是docker初始化是设置的，密钥相同
spring.minio.secret-key=wJalrXUtnFEMI/K7MDENG/bPxRfiCYEXAMPLEKEY
# minio的地址
spring.minio.url=http://10.0.0.7:9000
spring.minio.bucket-name=test
spring.thymeleaf.cache=false
````

### 添加minio配置类 MinioConfiguration

### 封装minio方法 MinioBean

### 添加html模板

### 添加controller  FileController

### 访问localhost:8081 访问测试

