package com.example.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import com.example.UserNotFoundException;
import com.example.model.User;
import com.example.repo.UserRepo;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.CachePut;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
@Service
public class UserServiceImpl implements UserService {

	@Autowired
	private UserRepo userRepo;
	@Override
	public User saveUser(User user) {
		return userRepo.save(user);
	}

	@Override
	public List<User> saveAll(List<User> users) {
		return userRepo.saveAll(users);
	}

	@Override
	@Transactional
	@CachePut(value = "user",key = "#id")
	public User updateUser(int id, User user) {
		User user1 = userRepo.findById(id).
				orElseThrow(()->(new UserNotFoundException("Employee not Exist ")));
				return userRepo.save(user1);
	}

	@Override
	@Cacheable(value = "user",key="#id")
	public User getOne(int id) {
		User user1 = userRepo.findById(id).
				orElseThrow(()->(new UserNotFoundException("Employee not Exist "+id)));
				return (user1);
	}

	@Override
	public List<User> getAllUser() {
		return userRepo.findAll();
	}

	@Override
	@CacheEvict(value = "user",allEntries = true)
	@Transactional
	public void deleteUser(int id) {
		User user1 = userRepo.findById(id).
				orElseThrow(()->(new UserNotFoundException("Employee not Exist ")));
				userRepo.delete(user1);
	}

}
