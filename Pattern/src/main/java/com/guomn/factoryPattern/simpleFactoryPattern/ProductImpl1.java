package com.guomn.factoryPattern.simpleFactoryPattern;

/**
 * Created by GuoMengnan on 2018/9/12.
 */

public class ProductImpl1 extends Product{

	ProductImpl1(){
		super();
		diff();
	}

	@Override
	public void diff() {
		this.name = "I am ProductImpl1 * *";
	}
}
