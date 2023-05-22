package com.example.demo.config;


import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.redis.connection.RedisConnectionFactory;
import org.springframework.data.redis.connection.lettuce.LettuceConnectionFactory;
import org.springframework.data.redis.core.RedisTemplate;

import com.example.demo.entity.User;
@Configuration
public class RedisConfig {

	//1. crate connection
	@Bean
	public RedisConnectionFactory connectionFactory() {
		return new LettuceConnectionFactory();
	}
	
	//2. create redis template
	@Bean
	public RedisTemplate<String, User> redisTemplate(){
		RedisTemplate <String, User> template=new RedisTemplate<>();
		template.setConnectionFactory(connectionFactory());
		return template;
	}
}
