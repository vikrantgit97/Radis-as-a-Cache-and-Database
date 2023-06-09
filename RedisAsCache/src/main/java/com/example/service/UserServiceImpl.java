package com.example.service;

import com.example.exception.UserNotFoundException;
import com.example.model.User;
import com.example.repo.UserRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.CachePut;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;
import java.util.logging.Logger;

@Service
public class UserServiceImpl implements UserService {

	private static final Logger logger = Logger.getLogger(String.valueOf(UserServiceImpl.class));
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
		System.out.println("from db ");
		logger.info("from db -- updateUser(int id, User user)" );
				return userRepo.save(user1);
	}

	@Override
	@Cacheable(value = "user",key="#id")
	public User getOne(int id) {
		User user1 = userRepo.findById(id).
				orElseThrow(()->(new UserNotFoundException("Employee not Exist "+id)));
		logger.info("from db -- getOne(int id)" );
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
		logger.info("from db -- deleteUser(int id)" );
				userRepo.delete(user1);
	}

}
