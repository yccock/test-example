package com.test.springtest;

import com.test.module.dao.UserDAO;
import com.test.module.domain.User;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

public class TestUserService extends BaseTest {

    @Autowired
    private UserDAO userDAO;

    @Test
    public void testSelect() {
        User user = userDAO.findOneById(1L);
    }
}
