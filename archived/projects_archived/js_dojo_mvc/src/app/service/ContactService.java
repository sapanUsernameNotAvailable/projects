package app.service;

import java.util.List;

import app.model.Contact;

public interface ContactService {
	public void addContact(int id, String name, String phone);
	public List<Contact> listContact();
	public void removeContact(Integer id);
}
