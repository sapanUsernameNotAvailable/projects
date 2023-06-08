package app.dao;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import app.model.Contact;
import app.utils.SessionFactoryMaker;

@Repository
public class DaoImpl implements Dao {
	@Autowired
	SessionFactoryMaker sessionFactoryMaker;

	public void addContact(Contact contact) {
		SessionFactory sessionFactory = sessionFactoryMaker.getSessionFactory();
		Session session = sessionFactory.openSession();
		session.beginTransaction();
		session.saveOrUpdate(contact);
		session.getTransaction().commit();
		session.close();
	}
	public List<Contact> listContact() {
		SessionFactory sessionFactory = sessionFactoryMaker.getSessionFactory();
		Session session = sessionFactory.openSession();
		session.beginTransaction();
		List<Contact> result = (List<Contact>) session.createCriteria(Contact.class, "ct").list();
		session.getTransaction().commit();
		session.close();
		return result;
	}
	public void removeContact(Integer id) {
		SessionFactory sessionFactory = sessionFactoryMaker.getSessionFactory();
		Session session = sessionFactory.openSession();
		session.beginTransaction();
		Contact contact = (Contact) session.createCriteria(Contact.class).add(Restrictions.eq("id", id)).uniqueResult();
		session.delete(contact);
		session.getTransaction().commit();
		session.close();
	}
}
