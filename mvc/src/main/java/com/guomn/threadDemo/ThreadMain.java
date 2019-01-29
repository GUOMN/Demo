package com.guomn.threadDemo;

/**
 * Created by GuoMengnan on 2018/8/3.
 */

public class ThreadMain {

	ProduceConsumeDemo p = new ProduceConsumeDemo();


	public void consume(){
		Consumer demo = new Consumer(p);
		demo.start();
		System.out.println("hello Main");
	}

	public void produce(){
		Thread thread = new Thread(new Producer(p));
		thread.start();
		System.out.println("hello Main");
	}


















	public static void main(String[] args){
		ThreadMain main = new ThreadMain();
		main.produce();
		main.consume();
	}
}
