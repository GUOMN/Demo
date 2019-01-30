package com.guomn.blogDemo;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import static java.lang.Thread.sleep;

/**
 * Created by GuoMengnan on 2019/1/30.
 */
@RestController
public class HealthchkController {

	@GetMapping("/healthchk")
	public String healthchk() throws InterruptedException {
		sleep(10);
		return "OK";
	}
}
