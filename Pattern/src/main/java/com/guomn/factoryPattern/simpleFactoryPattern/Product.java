package com.guomn.factoryPattern.simpleFactoryPattern;

/**
 * 抽象产品类
 * Created by GuoMengnan on 2018/9/12.
 */

public abstract class Product {
	protected String name = "I am a abstract product ~ ~";

	public void display(){
		System.out.println(name);
	}

	public abstract void diff();
}
