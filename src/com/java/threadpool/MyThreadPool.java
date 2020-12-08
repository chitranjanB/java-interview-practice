package com.java.threadpool;

import java.util.concurrent.LinkedBlockingQueue;

public class MyThreadPool {
	private final PoolWorker[] threads;
	private final LinkedBlockingQueue<Runnable> queue;

	public MyThreadPool(int nThreads) {
		queue = new LinkedBlockingQueue<>(nThreads);
		threads = new PoolWorker[nThreads];

		for (int i = 0; i < nThreads; i++) {
			threads[i] = new PoolWorker(queue);
			threads[i].start();
		}
	}

	public void execute(Runnable task) {
		try {
			queue.put(task);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}
}