package com.guomn.demowebflux;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.EnableConfigurationProperties;

@SpringBootApplication
@EnableAutoConfiguration
public class DemoWebfluxApplication {

	public static void main(String[] args) {
		SpringApplication.run(DemoWebfluxApplication.class, args);
	}
}
