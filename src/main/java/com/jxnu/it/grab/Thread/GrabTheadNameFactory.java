package com.jxnu.it.grab.Thread;

import java.util.concurrent.ThreadFactory;
import java.util.concurrent.atomic.AtomicInteger;

public class GrabTheadNameFactory implements ThreadFactory {
	private String prefix;
	private AtomicInteger atomicInteger = new AtomicInteger(0);

	public GrabTheadNameFactory(String prefix) {
		this.prefix = prefix;
	}

	@Override
	public Thread newThread(Runnable r) {
		Thread thread = new Thread(r);
		thread.setName(this.prefix + "-" + atomicInteger.incrementAndGet());
		thread.setDaemon(false);
		return thread;
	}
}
