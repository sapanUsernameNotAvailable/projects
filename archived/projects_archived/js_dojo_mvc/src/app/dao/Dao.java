package app.dao;

import java.util.List;

import app.model.Contact;

public interface Dao {
	public void addContact(Contact contact);
	public List<Contact> listContact();
	public void removeContact(Integer id);
}
