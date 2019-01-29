package com.guomn.factoryPattern.simpleFactoryPattern;

/**
 * Created by GuoMengnan on 2018/9/12.
 */

public class SimpleFactory {

	public static Product SimpleFactory(String choice){
		Product p = null;
		switch(choice){
			case "1" : p = new ProductImpl1(); break;
			case "2" : p = new ProductImpl2(); break;
		}
		return p;
	}

	public static void main(String[] args) {
		Product p1 = SimpleFactory("1");
		Product p2 = SimpleFactory("2");

		p1.display();
		p2.display();
	}


}
