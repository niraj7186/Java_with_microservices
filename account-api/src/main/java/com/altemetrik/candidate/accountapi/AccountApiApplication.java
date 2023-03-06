package com.altemetrik.candidate.accountapi;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.context.annotation.Bean;
import org.springframework.web.client.RestTemplate;


@SpringBootApplication
@EnableFeignClients
@EnableEurekaClient
public class AccountApiApplication {

//	@Bean
//	public RestTemplate restTemplate(){
//		return new RestTemplate();
//	}
	public static void main(String[] args) {
		SpringApplication.run(AccountApiApplication.class, args);
		System.out.println("Account Started");
	}

}
