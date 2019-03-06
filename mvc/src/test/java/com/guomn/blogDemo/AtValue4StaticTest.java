package com.guomn.blogDemo;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.time.Instant;
import java.time.LocalTime;

/**
 * Created by GuoMengnan on 2018/9/29.
 */
@RunWith(SpringRunner.class)
@SpringBootTest
public class AtValue4StaticTest {
	@Test
	public void testIOjection(){
		System.out.println("直接注入static变量无效：" + AtValue4Static.getStaticVar());
		System.out.println("非静态的set方法注入有效：" + AtValue4Static.getStaticVar2());
		System.out.println("诸如后给静态变量赋值无效：" + AtValue4Static.getVar2Value());
	}


	public static void main(String[] args) {
		System.out.println(LocalTime.now());
	}

}