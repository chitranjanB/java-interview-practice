package com.java.threadpool;

public class SuppliedTask implements Runnable {

	private int num;

	public SuppliedTask(int n) {
		num = n;
	}

	public void run() {
		try {
			Thread.sleep(2000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		System.out.println("Task " + num + " is running.");
	}
}