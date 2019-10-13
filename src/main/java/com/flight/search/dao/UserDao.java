package com.flight.search.dao;


import com.flight.search.entity.Users;

public interface UserDao {

    public boolean checkLogin(String username, String password);

    public Users getUser(String username);

}

