package cache;

import models.Entity;
import db.Dao;

/**
 * This Class represents wraps around DAO layer and our cache store. So while
 * the service layer will use this class for persistence, this class will
 * internally be using caching mechanism for performance gain. Since its being
 * used directly by service layer for persistence, this layer is aware of
 * application domain models. This class is thread safe. Since all the methods
 * calling of this class which call dao methods are synchronized, dao methods
 * themselves need not be synchronized.
 * */
public class Store {
	Cache<Entity> cache;
	Dao dao;

	public Store() {
		cache = new Cache<Entity>(50);
		dao = new Dao();
	}
	public synchronized void create(Entity entity) {
		cache.create(entity);
		dao.create(entity);
	}
	public synchronized void delete(int id) {
		cache.delete(id);
		dao.delete(id);
	}
	public synchronized Entity read(int id) {
		Entity entity = cache.read(id);
		if (entity == null) { // cache miss
			entity = dao.read(id);
			cache.create(entity);
		}
		return entity;
	}
	/**
	 * control method
	 * */
	public synchronized Entity directRead(int id) {
		Entity entity = dao.read(id);
		return entity;
	}
}
