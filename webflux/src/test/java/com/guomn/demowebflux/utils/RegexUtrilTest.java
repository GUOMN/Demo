package com.guomn.demowebflux.utils;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import static org.junit.Assert.*;

/**
 * Created by GuoMengnan on 2018/8/30.
 */

@RunWith(SpringRunner.class)
@SpringBootTest
public class RegexUtrilTest {

	@Test
	public void isMatch() {
		System.out.println(RegexUtril.isMatch("1234@t.email"));
	}
}