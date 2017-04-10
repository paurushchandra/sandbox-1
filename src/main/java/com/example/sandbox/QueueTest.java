package com.example.sandbox;

import java.util.concurrent.BlockingQueue;
import java.util.concurrent.LinkedBlockingQueue;

import org.apache.log4j.Logger;

public class QueueTest {

	private static Logger LOGGER = Logger.getLogger(QueueTest.class);

	public static void main(String[] args) throws InterruptedException {
		BlockingQueue<String> queue = new LinkedBlockingQueue<String>();
		new Thread(new RunnableImpl(queue)).start();
		queue.put("hello");
		queue.put("world");
		LOGGER.info("hello world");
	}

	public static class RunnableImpl implements Runnable {

		BlockingQueue<String> queue;
		private Logger LOGGER1 = Logger.getLogger(RunnableImpl.class);

		public RunnableImpl(BlockingQueue<String> queue) {
			super();
			this.queue = queue;
		}

		@Override
		public void run() {
			try {
				while (true) {
					LOGGER1.info(queue.take());
				}
			} catch (InterruptedException e) {
				e.printStackTrace();
			}

		}
	}

}
