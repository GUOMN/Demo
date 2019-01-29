package com.guomn.demowebflux.controller;

import org.springframework.http.codec.ServerSentEvent;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import reactor.core.publisher.Flux;
import reactor.util.function.Tuples;

import java.time.Duration;
import java.util.concurrent.ThreadLocalRandom;

/**
 * Created by GuoMengnan on 2018/8/24.
 * SSE Demo
 */
@RestController
public class ServerPushDemo {

	@GetMapping("getPush")
	public Flux<ServerSentEvent<Integer>> randomNumbers() {
		return Flux.interval(Duration.ofSeconds(1))
				.map(seq -> Tuples.of(seq, ThreadLocalRandom.current().nextInt()))
				.map(data -> ServerSentEvent.<Integer>builder()
						.event("random")
						.id(Long.toString(data.getT1()))
						.data(data.getT2())
						.build());
	}
}
