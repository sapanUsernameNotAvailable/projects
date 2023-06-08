package app.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import app.service.ContactService;
import app.utils.GsonMaker;

@Controller
public class ContactData {
	@Autowired
	ContactService contactService;
	@Autowired
	GsonMaker gsonMaker;

	@RequestMapping(value = "/addContact", method = RequestMethod.POST)
	public @ResponseBody
	String addContact(@RequestParam("id") int id, @RequestParam("name") String name, @RequestParam("phone") String phone) {
		contactService.addContact(id, name, phone);
		return "contact added";
	}
	@RequestMapping(value = "/removeContact", method = RequestMethod.GET)
	public @ResponseBody
	String removeContact(@RequestParam int id) {
		contactService.removeContact(id);
		return "contact deleted";
	}
	@RequestMapping(value = "/listContacts", method = RequestMethod.GET)
	public @ResponseBody
	String listContacts() {
		return gsonMaker.getGson().toJson(contactService.listContact());
	}
}
