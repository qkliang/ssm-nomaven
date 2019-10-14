package com.lqk.demo;

public class RunnableDemo implements Runnable{
	private volatile int ticket = 10;
	@Override
	public synchronized void run() {
		for(int i=0;i<20;i++){
			if(this.ticket>0){
				System.out.println(Thread.currentThread().getName()+"售票：ticket" + this.ticket);				
				ticket--;
			}
		}	
	}
	public static void main(String[] args) {
		RunnableDemo demo = new RunnableDemo();
		Thread t1 = new Thread(demo);
		Thread t2 = new Thread(demo);
		Thread t3 = new Thread(demo);
		t1.start();
		t2.start();
		t3.start();
	}
}
