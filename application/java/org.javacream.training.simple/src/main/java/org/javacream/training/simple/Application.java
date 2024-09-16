package org.javacream.training.simple;

import java.util.Date;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

public class Application {

	public static void main(String[] args) {

		Executors.newScheduledThreadPool(1).scheduleAtFixedRate(() -> System.out.println("Scheduling at " + new Date()), 0, 1, TimeUnit.MINUTES);
	}

}
