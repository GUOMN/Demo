package com.guomn.blogDemo;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.SpringBootConfiguration;

/**
 * @Value注解和static变量的问题
 * Created by GuoMengnan on 2018/9/29.
 */
//@Configuration
@SpringBootConfiguration
public class AtValue4Static {

/*
	// 1、@Value不能直接用于final变量
	@Value("${finalvar}")
//	private final static String finalvar;
*/

	// 2、@Value注入是在Spring容器启动完成后完成的，所以直接对static变量注入是无效的
	@Value("${AtValue4Static.staticVar}")
	private static String staticVar; // 注入无效

	//应该对静态变量使用非静态方法注入
	private static String staticVar2;
	@Value("${AtValue4Static.staticVar2}")
	public void setStaticVar2(String var) {
		staticVar2 = var;
	}

	// 3、对于使用了@Value的 静态变量，在整个系统中不能再静态代码中获取其值，也不能将其值赋给静态变量
	private final static String var2Value = staticVar2;


	public static String getStaticVar() {
		return staticVar;
	}

	public static String getStaticVar2() {
		return staticVar2;
	}

	public static String getVar2Value() {
		return var2Value;
	}
}
