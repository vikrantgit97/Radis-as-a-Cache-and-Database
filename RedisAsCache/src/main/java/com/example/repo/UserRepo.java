package com.example.repo;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.model.User;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepo extends JpaRepository<User,Integer> {

}
