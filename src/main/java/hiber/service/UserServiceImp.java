package hiber.service;

import hiber.dao.UserDao;
import hiber.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional(readOnly = true)
public class UserServiceImp implements UserService {

   private final UserDao userDao;

   @Autowired
   public UserServiceImp(UserDao userDao) {
      this.userDao = userDao;
   }

   @Transactional
   @Override
   public void addUser(User user) {
      userDao.add(user);
   }

   @Override
   public List<User> getUsers() {
      return userDao.findAll();
   }

   @Override
   public User getUser(int id) {
      return userDao.findById(id);
   }

   @Transactional
   @Override
   public void deleteUser(int id) {
      userDao.delete(userDao.findById(id));
   }

   @Transactional
   @Override
   public void updateUser(User user) {
      userDao.update(user);
   }
}
