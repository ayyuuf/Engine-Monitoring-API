package com.monitoring.sitemanagement.service;

import com.monitoring.sitemanagement.dao.UserDAOImpl;
import com.monitoring.sitemanagement.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UserServiceImpl implements UserService {


    @Autowired
    private UserDAOImpl userDAO;


    @Override
    public List<User> getAllUsers() {
        return userDAO.getAllUsers();
    }

    @Override
    public void AddUser(User user) {
        userDAO.save(user);

    }

    @Override
    public int count() {
        return userDAO.count();
    }

}
