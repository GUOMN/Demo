package com.guomn.factoryPattern.simpleFactoryPattern;

/**
 * Created by GuoMengnan on 2018/9/12.
 */

public class ProductImpl2 extends Product{
	ProductImpl2(){
		super();
		diff();
	}
	@Override
	public void diff() {
		this.name = "I am ProductImp2 # #";
	}
}
