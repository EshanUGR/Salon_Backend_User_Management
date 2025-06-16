package com.example.demo.service;

import java.util.List;

import com.example.demo.exception.UserException;
import com.example.demo.model.User;

public interface UserService {
  User careateUser(User user) ;

  User getUserById(Long id) throws UserException;

  List<User> getAllUsers();

  String deleteUser(Long id) throws UserException;

  User updateUser(Long id,User user) throws UserException;



}
