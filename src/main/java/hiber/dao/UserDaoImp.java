package hiber.dao;

import hiber.model.User;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class UserDaoImp implements UserDao {

   @PersistenceContext
   private final EntityManager entityManager;

   @Autowired
   public UserDaoImp(EntityManager em) {
      this.entityManager = em;
   }

   @Override
   public void add(User user) {
      entityManager.persist(user);
   }

   @Override
   public void update(User user) {
      entityManager.merge(user);
      //Вместо нормального обновления создаёт плодит новые сучности, решение - выбросить это и использовать репозиторий.
   }

   @Override
   public void delete(User user) {
      entityManager.remove(user);
   }

   @Override
   public User findById(int id) {
      return entityManager.find(User.class, id);
   }

   @Override
   public List<User> findAll() {
      return entityManager.createQuery("select u from User u").getResultList();
   }

}
