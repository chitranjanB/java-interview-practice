package com.java.threadpool;

import java.util.LinkedList;
import java.util.Queue;

public class MyThreadPool {
	private final PoolWorker[] threads;
	private final Queue<Runnable> queue;

	public MyThreadPool(int nThreads) {
		queue = new LinkedList<>();
		threads = new PoolWorker[nThreads];

		for (int i = 0; i < nThreads; i++) {
			threads[i] = new PoolWorker(queue);
			threads[i].start();
		}
	}

	public void execute(Runnable task) {
		synchronized (queue) {
			queue.add(task);
			queue.notify();
		}
	}
}