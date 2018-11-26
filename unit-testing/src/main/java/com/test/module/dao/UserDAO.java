package com.test.module.dao;


import com.test.module.domain.User;

public interface UserDAO {

    void save(User user) throws Exception;

    void update(User user) throws Exception;

    User findOneById(Long id);
}
