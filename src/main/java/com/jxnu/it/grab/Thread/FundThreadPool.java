package com.jxnu.it.grab.Thread;

import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;

public class FundThreadPool {
	public static final ScheduledExecutorService scheduledExecutorService = Executors.newScheduledThreadPool(10, new GrabTheadNameFactory("fund"));

	public static ScheduledExecutorService newSheduledInstance() {
		synchronized (FundThreadPool.class) {
			return scheduledExecutorService;
		}
	}


}
