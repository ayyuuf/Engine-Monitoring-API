package com.monitoring.sitemanagement.dao;

import com.monitoring.sitemanagement.model.User;

import java.util.List;

public interface UserDAO {

    List<User> getAllUsers();
    public void save(User user);
    public int count();



}
