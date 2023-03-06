package com.altimetrik.springbootkafka;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class SpringbootKafkaPracticeApplication {

	public static void main(String[] args) {
		SpringApplication.run(SpringbootKafkaPracticeApplication.class, args);
		System.out.println("Kafka service started");
	}

}
