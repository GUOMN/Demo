package com.guomn.threadDemo;

/**
 * Created by GuoMengnan on 2018/8/3.
 */

public class Consumer extends Thread{

	ProduceConsumeDemo p;

	/**
	 * Allocates a new {@code Thread} object. This constructor has the same
	 * effect as {@linkplain #Thread(ThreadGroup, Runnable, String) Thread}
	 * {@code (null, null, gname)}, where {@code gname} is a newly generated
	 * name. Automatically generated names are of the form
	 * {@code "Thread-"+}<i>n</i>, where <i>n</i> is an integer.
	 */
	public Consumer() {
	}

	Consumer(ProduceConsumeDemo p){
		this.p = p;
	}

	public void run() {
		try {
			sleep(200);
			consume();
			sleep(200);
			consume();
			sleep(200);
			consume();
			sleep(200);
			consume();
			sleep(200);
			consume();
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}


	/**
	 * 消费
	 */
	private void consume(){
		p.consume();
	}


	/**
	 * 示例demo
	 */
	private void demo(){
		try {
			sleep(1000);
			System.out.println("hello demo");
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}
}
