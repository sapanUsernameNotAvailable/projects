package db;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import models.Entity;

public class Dao {
	Connection connection;
	// state CRD
	PreparedStatement createStatement;
	PreparedStatement readStatement;
	PreparedStatement deleteStatement;

	public Dao() {
		try {
			Class.forName("com.mysql.jdbc.Driver");
			connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/cachingDB", "root", "root");
			// CRD
			createStatement = connection.prepareStatement("insert into Entity(id,name) values(?,?);");
			readStatement = connection.prepareStatement("select * FROM Entity WHERE `id`=?;");
			deleteStatement = connection.prepareStatement("delete from Entity where `id`=?;");
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	public synchronized void create(Entity entity) {
		try {
			createStatement.setInt(1, entity.getId());
			createStatement.setString(2, entity.getName());
			createStatement.execute();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	public synchronized Entity read(int id) {
		Entity entity = null;
		try {
			readStatement.setInt(1, id);
			ResultSet rs = readStatement.executeQuery();
			if (rs.next()) {
				entity = new Entity(rs.getInt("id"), rs.getString("name"));
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return entity;
	}
	public synchronized void delete(int id) {
		try {
			deleteStatement.setInt(1, id);
			deleteStatement.execute();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}