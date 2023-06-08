package com.sapan;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

public class PageFetcher {

	public String fetch(String url) throws IOException {

		URL serverAddress = new URL(url);
		HttpURLConnection connection = (HttpURLConnection) serverAddress
				.openConnection();

		connection.setRequestMethod("GET");
		connection.setDoOutput(true);
		connection.setReadTimeout(10000);
		connection.connect();

		BufferedReader bufferedReader = new BufferedReader(
				new InputStreamReader(connection.getInputStream()));
		StringBuilder builder = new StringBuilder();
		String line;
		while ((line = bufferedReader.readLine()) != null) {
			builder.append(line + '\n');
		}

		String stringPage = builder.toString();

		connection.disconnect();

		return stringPage;
	}
}
