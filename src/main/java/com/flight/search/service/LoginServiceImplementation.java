package com.flight.search.service;


import com.flight.search.dao.UserDao;
import com.flight.search.entity.Users;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;

@Service
public class LoginServiceImplementation implements LoginService {

    @Autowired
    private UserDao userDao;

    @Override
    @Transactional
    public Users getUser(String username) {
        return userDao.getUser(username);
    }

    @Override
    @Transactional
    public boolean checkLogin(String username, String password) {
        return userDao.checkLogin(username, password);
    }

}
