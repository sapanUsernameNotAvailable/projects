package app.utils;

import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.springframework.stereotype.Component;

@Component
public class SessionFactoryMaker {
	public SessionFactory getSessionFactory() {
		return new Configuration().configure().buildSessionFactory();
	}
}
