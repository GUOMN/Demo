package com.guomn.threadDemo;

/**
 * Created by GuoMengnan on 2018/8/3.
 */

public class Producer implements Runnable {

	ProduceConsumeDemo p;

	public Producer() {
	}

	Producer(ProduceConsumeDemo p){
		this.p = p;
	}


	/**
	 * When an object implementing interface <code>Runnable</code> is used
	 * to create a thread, starting the thread causes the object's
	 * <code>run</code> method to be called in that separately executing
	 * thread.
	 * <p>
	 * The general contract of the method <code>run</code> is that it may
	 * take any action whatsoever.
	 *
	 * @see Thread#run()
	 */
	@Override
	public void run() {
		try {
			produce();
			Thread.sleep(200);
			produce();
			Thread.sleep(200);
			produce();
			Thread.sleep(200);
			produce();
			produce();
			produce();
			produce();
			Thread.sleep(200);
			produce();
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}

	/**
	 * 生产
	 */
	private void produce(){
		p.produce();
	}

	/**
	 * 示例demo
	 */
	private void demo(){
		try {
			// 因为没有继承Thread类，所以用类名需要引用静态方法
			Thread.sleep(1000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		System.out.println("hello demo1");
	}
}
