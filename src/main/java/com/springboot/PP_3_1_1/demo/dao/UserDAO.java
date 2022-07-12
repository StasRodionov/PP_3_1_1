package com.springboot.PP_3_1_1.demo.dao;

import com.springboot.PP_3_1_1.demo.models.User;

import java.util.List;

public interface UserDAO {

    List<User> index();

    User showUser(long id);

    void save(User user);

    void update(User userUpdated);

    void deleteUser(long id);
}