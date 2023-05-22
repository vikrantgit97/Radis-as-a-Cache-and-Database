package com.example.demo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.example.demo.dao.UserDao;
import com.example.demo.entity.User;

@SpringBootApplication
public class RedisAsDatabaseApplication implements CommandLineRunner{
	@Autowired (required = true)
	private UserDao userDao;
	
	
	public static void main(String[] args) {
		SpringApplication.run(RedisAsDatabaseApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
	 userDao.save(new User(101, "raga", 'f', "satara"));	
	 userDao.save(new User(102, "sundar", 'm', "kunnur"));	
	 userDao.save(new User(103, "satya", 'm', "guntur"));	
	 
	 
	 System.out.println("-------------------------------------------------");
	 userDao.getAll().forEach((k,v)->System.out.println(k+"  "+v));
	 System.out.println("-------------------------------------------------");
	 userDao.delete(101);
	 userDao.getAll().forEach((k,v)->System.out.println(k+"  "+v));
	 System.out.println(userDao.getOne(101));
	}
}
