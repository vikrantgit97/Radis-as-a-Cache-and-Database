package com.example.service;

import java.util.List;

import com.example.model.User;

public interface UserService {


	public User saveUser(User user);

	List<User> saveAll(List<User> users);
	
	public User updateUser(int id,User user);
	
	public User getOne(int id);
	
	public List<User> getAllUser();
	//redis uses hashing techniques thats why return type is map
	//public Map<Integer,User> getAll();
	
	public void deleteUser(int id);
}
