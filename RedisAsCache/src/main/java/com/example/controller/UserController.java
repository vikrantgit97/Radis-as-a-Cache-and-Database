package com.example.controller;

import com.example.model.User;
import com.example.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.net.http.HttpResponse;
import java.util.List;

@RestController
public class UserController {

    @Autowired
    private UserService userService;

    @PostMapping("/userSave")
    public ResponseEntity<User> saveUser(@RequestBody User user){
        return new ResponseEntity<>(userService.saveUser(user),HttpStatus.CREATED);
    }
    @PostMapping("/userSaveAll")
    public ResponseEntity<List<User>> saveAllUser(@RequestBody List<User> users){
        return new ResponseEntity<>(userService.saveAll(users),HttpStatus.CREATED);
    }
    @PostMapping("/userUpdate")
    public ResponseEntity<User> updateUser(@PathVariable int id,@RequestBody User user){
        return new ResponseEntity<>(userService.updateUser(id,user),HttpStatus.OK);
    }
    @GetMapping("/user/{id}")
    public ResponseEntity<User> getOneUser(@PathVariable int id){
        return new ResponseEntity<>(userService.getOne(id),HttpStatus.OK);
    }
    @GetMapping("/userAll")
    public ResponseEntity<List<User>> getOneUser(){
        return new ResponseEntity<>(userService.getAllUser(),HttpStatus.OK);
    }
    @DeleteMapping("/user/{id}")
    public void deleteOneUser(@PathVariable int id){
        userService.deleteUser(id);
    }

}
