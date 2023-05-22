package com.example.demo.dao;

import java.util.Map;

import javax.annotation.Resource;

import org.springframework.data.redis.core.HashOperations;
import org.springframework.stereotype.Repository;

import com.example.demo.entity.User;

@Repository
public class UserDaoImpl implements UserDao {

	// ref type (hash type), key type (primary key), value type(Object)
	@Resource(name = "redisTemplate") // it is java based annotaion see the impl type and link that object here advanced autowiring coming from redistemplate
	private HashOperations<String, Integer, User> hashOperations;

	private String KEY = "USER";

	@Override
	public void save(User user) {
		hashOperations.putIfAbsent(KEY, user.getId(), user);
	}

	@Override
	public void update(User user) {
		hashOperations.put(KEY, user.getId(), user);
	}

	@Override
	public Map<Integer, User> getAll() {
		return hashOperations.entries(KEY);
	}

	@Override
	public void delete(int id) {
		hashOperations.delete(KEY, id);
	}

	@Override
	public User getOne(int id) {
		return hashOperations.get(KEY, id);
	}

}
