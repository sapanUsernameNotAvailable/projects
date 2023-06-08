package app.utils;

import org.springframework.stereotype.Component;

import com.google.gson.Gson;
@Component
public class GsonMaker {
	public Gson getGson() {
		return new Gson();
	}
}
