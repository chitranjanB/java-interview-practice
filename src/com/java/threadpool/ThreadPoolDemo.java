package com.java.threadpool;

import com.java.threadpool.SuppliedTask;
import com.java.threadpool.MyThreadPool;

public class ThreadPoolDemo {

	public static void main(String[] args) {
		MyThreadPool pool = new MyThreadPool(3);

		for (int i = 0; i < 8; i++) {
			SuppliedTask task = new SuppliedTask(i);
			pool.execute(task);
		}
	}
}