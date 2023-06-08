package cache;

import java.util.*;

/**
 * This class represents the cache data store.Its size is determined dynamically
 * when the cache object is made. This object is thread safe. Cache objects must
 * implement Cacheable.
 * */
public class Cache<T extends Cacheable> {
	private int maximumCacheSize;
	// because we need to know the eldest entry int the map
	private LinkedHashMap<Integer, T> cacheObjects;

	@SuppressWarnings("serial")
	public Cache(int size) {
		maximumCacheSize = size;
		cacheObjects = new LinkedHashMap<Integer, T>() {
			protected boolean removeEldestEntry(Map.Entry<Integer, T> eldest) {
				return this.size() > Cache.this.maximumCacheSize;
			}
		};
	}
	public synchronized void create(T cacheObject) {
		this.cacheObjects.put(cacheObject.getKey(), cacheObject);
	}
	public synchronized T read(int key) {
		return this.cacheObjects.get(key);
	}
	public synchronized void delete(int key) {
		this.cacheObjects.remove(key);
	}
	public synchronized Set<Integer> getKeys() {
		return cacheObjects.keySet();
	}
}