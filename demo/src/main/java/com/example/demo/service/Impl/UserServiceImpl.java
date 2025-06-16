package com.example.demo.service.Impl;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.example.demo.exception.UserException;
import com.example.demo.model.User;
import com.example.demo.repository.UserRepository;
import com.example.demo.service.UserService;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class UserServiceImpl  implements UserService{

  
  private final UserRepository userRepository;
   
  
   public User careateUser(User user)
   {
  return userRepository.save(user);
   }



  public User getUserById(Long id) throws UserException
  {
    Optional<User> otp=userRepository.findById(id);

  if(otp.isPresent())
  {
    return otp.get();
  }
 throw new UserException("user not found");
  }



  public List<User> getAllUsers()
  {
    return userRepository.findAll();
  }



  public String deleteUser(Long id) throws UserException
  {
    Optional<User> otp=userRepository.findById(id);


  if(otp.isEmpty())
  {
throw new UserException("user not exist  with id "+id);
  }
userRepository.deleteById(otp.get().getId());

return "User deleted";
  }


  @Override
  public User updateUser(Long id,User user) throws UserException
  {
    
  Optional<User> otp=userRepository.findById(id);
  if(otp.isEmpty())
  {
throw new UserException("user not found with id "+id);
  }
  User existingUser=otp.get();



 existingUser.setFullName(user.getFullName());
existingUser.setEmail(user.getEmail());

existingUser.setPhone(user.getPhone());

existingUser.setRole(user.getRole());

existingUser.setUsername(user.getUsername());
return userRepository.save(existingUser);
  }
  
}
