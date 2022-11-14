package com.monitoring.sitemanagement.service;

import com.monitoring.sitemanagement.model.User;

import java.util.List;

public interface UserService {

    List<User> getAllUsers();

    public User findByUsername(String username);
    public void AddUser(User user);

}
