package app.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class Main {
	@RequestMapping(value = "/index", method = RequestMethod.GET)
	String pubsub() {
		return "index";
	}
	// testing client
	@RequestMapping(value = "/mockingbird", method = RequestMethod.GET)
	String mockingbird() {
		return "mockingbird";
	}
}
