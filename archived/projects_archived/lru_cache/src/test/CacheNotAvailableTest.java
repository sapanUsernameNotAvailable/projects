package test;

import java.util.Random;

import org.junit.Test;

import cache.Store;

public class CacheNotAvailableTest {
	@Test
	public final void run() {
		Store store = new Store();
		Random randomGenerator = new Random();
		long startTime = System.currentTimeMillis();
		for (int i = 0; i < 10000; i++) {
			int randomIndex = randomGenerator.nextInt(75);
			store.directRead(randomIndex);
		}
		long endTime = System.currentTimeMillis();
		long timeTook = endTime - startTime;
		System.out.println("When caching not available, test took : " + timeTook + " ms");
	}
}
