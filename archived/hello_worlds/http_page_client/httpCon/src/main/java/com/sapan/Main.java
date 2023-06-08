package com.sapan;

import java.io.IOException;

public class Main {

	public static void main(String[] args) {

		PageFetcher fetcher = new PageFetcher();
		try {
			System.out.println(fetcher.fetch("http://www.google.com"));
		} catch (IOException e) {
			e.printStackTrace();
		}

	}

}
