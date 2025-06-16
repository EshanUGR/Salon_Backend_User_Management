package com.example.demo.controller;


import java.util.List;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.model.User;

import com.example.demo.service.UserService;

import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;

@RestController
@RequiredArgsConstructor
public class UserController {

@Autowired
private final UserService userService;

@PostMapping("/api/users")
public ResponseEntity<User> careateUser(@RequestBody @Valid User user)
{
 User createdUser=userService.careateUser(user);

 return new ResponseEntity<>(createdUser,HttpStatus.CREATED);
}


  @GetMapping("/api/users")
public ResponseEntity<List<User>>getUser()
{
List<User> users =userService.getAllUsers();
return new ResponseEntity<>(users,HttpStatus.OK);
}


@GetMapping("/api/users/{id}")
public ResponseEntity<User> getUserById(@PathVariable("id") Long id) throws Exception
{

User user=userService.getUserById(id);
return new ResponseEntity<>(user,HttpStatus.OK);
}

@PutMapping("/api/users/{id}")
public ResponseEntity<User> updateUser(@RequestBody User user, @PathVariable Long id ) throws Exception
{
  User updatedUser=userService.updateUser(id,user);
  return new ResponseEntity<>(updatedUser,HttpStatus.OK);

}






@DeleteMapping("/api/users/{id}")
public ResponseEntity<String> deleteUserById(@PathVariable Long id) throws Exception
{
  
userService.deleteUser(id);

return new ResponseEntity<>("User deleted",HttpStatus.ACCEPTED);
}


}
