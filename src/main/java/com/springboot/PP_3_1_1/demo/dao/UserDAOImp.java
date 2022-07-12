package com.springboot.PP_3_1_1.demo.dao;

import com.springboot.PP_3_1_1.demo.models.User;
import org.springframework.stereotype.Repository;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.List;


@Repository
public class UserDAOImp implements UserDAO {

    @PersistenceContext
    private EntityManager entityManager;

    @Override
    public List<User> index() {
        return entityManager.createQuery(
                "select user from User user", User.class)
                .getResultList();
    }
    @Override
    public User showUser(long id) {
        User user = entityManager.find(User.class, id);
        return user;
    }

    @Override
    public void save(User user) {
        entityManager.persist(user);
    }

    @Override
    public void update(User userUpdated) {
        entityManager.merge(userUpdated);
    }

    @Override
    public void deleteUser(long id) {
        User user = entityManager.find(User.class, id);
        entityManager.remove(user);
    }

}
