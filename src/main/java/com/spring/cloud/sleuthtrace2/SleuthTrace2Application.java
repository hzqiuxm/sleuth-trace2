package com.spring.cloud.sleuthtrace2;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.context.annotation.Bean;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

@EnableDiscoveryClient
@SpringBootApplication
@RestController
public class SleuthTrace2Application {

	private Logger logger = LoggerFactory.getLogger(SleuthTrace2Application.class);

	@Bean
	@LoadBalanced
	RestTemplate restTemplate(){

		return new RestTemplate();
	}


	@GetMapping("/trace2")
	public String trace(){

		logger.info("========= call trace2 =========");

		return "Trace2!";
	}

	public static void main(String[] args) {
		SpringApplication.run(SleuthTrace2Application.class, args);
	}
}
