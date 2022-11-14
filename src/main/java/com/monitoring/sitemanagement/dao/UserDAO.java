package com.monitoring.sitemanagement.dao;

import com.monitoring.sitemanagement.model.User;

import java.util.List;
import java.util.Optional;

public interface UserDAO {

    List<User> getAllUsers();
    public Optional<User> findByUsername(String username);
    public int save(User user);



}
