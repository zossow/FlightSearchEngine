package com.flight.search.service;

import com.flight.search.entity.Users;

public interface LoginService {
    public boolean checkLogin(String userName, String userPassword);
    public Users getUser(String username);

}
