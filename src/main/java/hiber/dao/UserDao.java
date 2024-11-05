package hiber.dao;

import hiber.model.User;

import java.util.List;

public interface UserDao {
   void add(User user);
   void update(User user);
   void delete(User user);
   User findById(int id);
   List<User> findAll();
}
