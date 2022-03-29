package com.wenxuezheng.study.minio.minio.config;

import io.minio.MinioClient;
import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;


/**
 * @author hu.bo@cestc.cn
 * @date 2022/3/29 4:57 PM
 */
@Configuration
@ConfigurationProperties(prefix = "spring.minio")
@Data
public class MinioConfiguration {
    private String accessKey;

    private String secretKey;

    private String url;

    private String bucketName;

    @Bean
    public MinioClient minioClient() {
        return MinioClient.builder()
                .endpoint(url)
                .credentials(accessKey, secretKey)
                .build();
    }
}
