package app.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import app.dao.Dao;
import app.model.Contact;

@Service
public class ContactServiceImpl implements ContactService {
	@Autowired
	Dao dao;

	@Transactional
	public void addContact(int id, String name, String phone) {
		dao.addContact(new Contact(id, name, phone));
	}
	@Transactional
	public List<Contact> listContact() {
		return dao.listContact();
	}
	@Transactional
	public void removeContact(Integer id) {
		dao.removeContact(id);
	}
}
