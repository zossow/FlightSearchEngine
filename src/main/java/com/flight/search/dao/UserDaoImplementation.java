package com.flight.search.dao;

import com.flight.search.entity.Users;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class UserDaoImplementation implements UserDao {

    @Autowired
    private SessionFactory sessionFactory;

    @Override
    public Users getUser(String username) {
        Session session = sessionFactory.getCurrentSession();
        String SQL_QUERY ="from Users as o where o.username =:username";
        Query query = session.createQuery(SQL_QUERY);
        query.setParameter("username",username);
        Users theUser = (Users) query.getSingleResult();
        return theUser;
    }

    @Override
    public boolean checkLogin(String username, String password){

        Session session = sessionFactory.getCurrentSession();
        System.out.println("Checking login");
        boolean userFound = false;
        String SQL_QUERY ="from Users as o where o.username =:username and o.password=:password";
        Query query = session.createQuery(SQL_QUERY);
        query.setParameter("username",username);
        query.setParameter("password",password);
        List list = query.list();

        if ((list != null) && (list.size() > 0)) {
            userFound= true;
        }

        return userFound;
    }
}


