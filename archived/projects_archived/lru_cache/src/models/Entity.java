package models;

import cache.Cacheable;

public class Entity implements Cacheable{
	int id;
	String name;

	public Entity() {
		super();
	}
	public Entity(int id, String name) {
		super();
		this.id = id;
		this.name = name;
	}
	public int getKey() {
		return id;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
}
