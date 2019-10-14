package com.lqk.demo;
/**
 * @author lqk
 * @date 2019/10/14
 *
 * 结果说明：
	(01) MyThread继承于Thread，它是自定义个线程。每个MyThread都会卖出10张票。
	(02) 主线程main创建并启动3个MyThread子线程。每个子线程都各自卖出了10张票。
 * */
public class ThreadDemo extends Thread {
	private int ticket = 10;
	@Override
	public void run() {
		for (int i = 0; i < 20; i++) {
			if(this.ticket > 0){
				System.out.println(this.getName()+"卖票：ticket"+this.ticket);
				ticket--;
			}
		}
	}

	public static void main(String[] args) {
		ThreadDemo t1 = new ThreadDemo();
		ThreadDemo t2 = new ThreadDemo();
		ThreadDemo t3 = new ThreadDemo();
		t1.start();
		t2.start();
		t3.start();
	}
}
