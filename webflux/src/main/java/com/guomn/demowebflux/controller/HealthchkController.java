package com.guomn.demowebflux.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import reactor.core.publisher.Mono;

import java.time.Duration;

/**
 * Created by GuoMengnan on 2018/8/24.
 */
@RestController
public class HealthchkController {

	@GetMapping("/healthchk")
	public Mono<String> healthchk(){
		return Mono.just("health check is OK!").delayElement(Duration.ofMillis(10));
	}
}
