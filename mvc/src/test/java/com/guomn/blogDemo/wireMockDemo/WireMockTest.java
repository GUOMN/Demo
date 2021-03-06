package com.guomn.blogDemo.wireMockDemo;

import com.github.tomakehurst.wiremock.core.WireMockConfiguration;
import com.github.tomakehurst.wiremock.junit.WireMockRule;
import org.junit.Rule;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.http.ResponseEntity;
import org.springframework.test.context.junit4.SpringRunner;

import static com.github.tomakehurst.wiremock.client.WireMock.*;
import static org.assertj.core.api.Assertions.assertThat;

/**
 * Created by GuoMengnan on 2019/3/6.
 */
@RunWith(SpringRunner.class)
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
public class WireMockTest {

	@Autowired
	private TestRestTemplate restTemplate;
	@Rule
	public WireMockRule wireMockRule = new WireMockRule(WireMockConfiguration.options().port(8888));

	@Test
	public void should_get_hello() throws Exception {
		wireMockRule.stubFor(get(urlEqualTo("/hello"))
				.willReturn(aResponse()
						.withHeader("Content-Type", "text/plain")
						.withBody("Hello world!")));

		ResponseEntity<String> response = restTemplate.getForEntity(String.format("http://localhost:%s/%s", 8888, "hello"),	String.class);


		assertThat(response.getBody()).isEqualTo("Hello world!");
	}
}
