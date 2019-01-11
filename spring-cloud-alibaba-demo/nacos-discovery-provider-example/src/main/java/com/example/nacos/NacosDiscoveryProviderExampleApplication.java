package com.example.nacos;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

@SpringBootApplication
@EnableDiscoveryClient
public class NacosDiscoveryProviderExampleApplication {

	public static void main(String[] args) {
		SpringApplication.run(NacosDiscoveryProviderExampleApplication.class, args);
	}

}

