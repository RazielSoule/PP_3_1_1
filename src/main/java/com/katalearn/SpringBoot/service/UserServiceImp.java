package com.katalearn.SpringBoot.service;

import com.katalearn.SpringBoot.model.User;
import com.katalearn.SpringBoot.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional(readOnly = true)
public class UserServiceImp implements UserService {

   private final UserRepository userRepository;

   @Autowired
   public UserServiceImp(UserRepository userRepository) {
      this.userRepository = userRepository;
   }

   @Transactional
   @Override
   public void addUser(User user) {
      userRepository.save(user);
   }

   @Override
   public List<User> getUsers() {
      return userRepository.findAll();
   }

   @Override
   public User getUser(int id) {
      return userRepository.findById(id).orElse(null);
   }

   @Transactional
   @Override
   public void deleteUser(int id) {
      userRepository.deleteById(id);
   }

   @Transactional
   @Override
   public void updateUser(int id, User user) {
      user.setId((long) id);
      userRepository.save(user);
   }
}
