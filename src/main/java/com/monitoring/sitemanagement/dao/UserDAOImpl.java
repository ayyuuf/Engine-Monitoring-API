package com.monitoring.sitemanagement.dao;

import com.monitoring.sitemanagement.model.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import java.util.List;


@Repository
public class UserDAOImpl implements UserDAO {

    @Autowired
    private JdbcTemplate jdbcTemplate;

    @Override
    public List<User> getAllUsers() {
        String query = "SELECT * from user";
        RowMapper<User> rowMapper = new UserMapper();
        List<User> list = jdbcTemplate.query(query, rowMapper);
        return list;
    }

    @Override
    public void save(User user) {
        String query = ("INSERT INTO user( name, username, password) VALUES('" + user.getName() + "','" + user.getUsername() + "'," + user.getPassword() + ")");
        jdbcTemplate.update(query);
    }

    @Override
    public int count() {
        String query = "SELECT COUNT(*) FROM user";
        return jdbcTemplate.queryForObject(query, Integer.class);
    }

}