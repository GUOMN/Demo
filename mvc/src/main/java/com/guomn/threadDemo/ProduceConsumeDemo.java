package com.guomn.threadDemo;

/**
 * Created by GuoMengnan on 2018/8/10.
 */

public class ProduceConsumeDemo {

	private static int  product = 0;
	final static private int  MAX_PRODUCT = 2;
	final static private int  MIN_PRODUCT = 0;

	/**
	 * 生产者生产出来的产品交给店员
	 */
	public synchronized void produce()
	{
		if(this.product >= MAX_PRODUCT){
			try
			{
				System.out.println("产品已满,请稍候再生产");
				wait();
			}
			catch(InterruptedException e)
			{
				e.printStackTrace();
			}
			return;
		}

		this.product++;
		System.out.println("生产者生产第" + this.product + "个产品.");
		notifyAll();   //通知等待区的消费者可以取出产品了
	}

	/**
	 * 消费者从店员取产品
	 */
	public synchronized void consume()
	{
		if(this.product <= MIN_PRODUCT)
		{
			try
			{
				System.out.println("缺货,稍候再取");
				wait();
			}
			catch (InterruptedException e)
			{
				e.printStackTrace();
			}
			return;
		}

		System.out.println("消费者取走了第" + this.product + "个产品.");
		this.product--;
		notifyAll();   //通知等待去的生产者可以生产产品了
	}

}
