package com.java.threadpool;

import java.util.Queue;

public class PoolWorker extends Thread {
	private Queue<Runnable> queue;

	public PoolWorker(Queue<Runnable> queue) {
		this.queue = queue;
	}

	public void run() {
		Runnable task = null;

		while (true) {
			synchronized (queue) {
				while (queue.isEmpty()) {
					try {
						queue.wait();
					} catch (InterruptedException e) {
						System.out.println("An error occurred while queue is waiting: " + e.getMessage());
					}
				}
				task = queue.poll();
			}

			// If we don't catch RuntimeException,
			// the pool could leak threads
			try {
				task.run();
			} catch (RuntimeException e) {
				System.out.println("Thread pool is interrupted due to an issue: " + e.getMessage());
			}
		}
	}
}