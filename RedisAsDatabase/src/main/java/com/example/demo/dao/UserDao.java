package com.example.demo.dao;

import java.util.Map;

import com.example.demo.entity.User;

public interface UserDao {

	public void save(User user);
	
	public void update(User user);
	
	public User getOne(int id);
	
	//redis uses hashing techniques thats why return type is map
	public Map<Integer,User> getAll();
	
	public void delete(int id);
}
