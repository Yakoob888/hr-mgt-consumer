package com.skytech.consumer;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.context.annotation.Bean;
import org.springframework.web.client.RestTemplate;

@SpringBootApplication
public class HrMgtConsumerApplication {

	public static void main(String[] args) {
		SpringApplication.run(HrMgtConsumerApplication.class, args);
	}
	
	@LoadBalanced
	@Bean(name = "template")
	public RestTemplate template() {
		return new RestTemplate();
	}

}
