package test;

import models.Entity;

import org.junit.runner.JUnitCore;
import org.junit.runner.Result;
import org.junit.runner.notification.Failure;

import cache.Store;

public class TestRunner {
	public static void main(String[] args) {
		Store store = new Store();
		for (int i = 0; i < 75; i++) {
			store.create(new Entity(i, i + " entity"));
		}
		Result result = JUnitCore.runClasses(CacheTestSuite.class);
		for (Failure failure : result.getFailures()) {
			System.out.println(failure.toString());
		}
		for (int i = 0; i < 75; i++) {
			store.delete(i);
		}
	}
}
