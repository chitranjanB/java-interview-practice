package com.java.threadpool;

import java.util.concurrent.LinkedBlockingQueue;

public class PoolWorker extends Thread {
	private LinkedBlockingQueue<Runnable> queue;

	public PoolWorker(LinkedBlockingQueue<Runnable> queue) {
		this.queue = queue;
	}

	public void run() {
		Runnable task = null;

		while (true) {

			try {
				task = queue.take();
			} catch (InterruptedException e) {
				System.out.println("An error occurred while queue is waiting: " + e.getMessage());
			}

			try {
				task.run();
			} catch (RuntimeException e) {
				System.out.println("Thread pool is interrupted due to an issue: " + e.getMessage());
			}
		}
	}
}