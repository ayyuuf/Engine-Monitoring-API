package com.monitoring.sitemanagement.dao;

import com.monitoring.sitemanagement.model.ProjectMapper;
import com.monitoring.sitemanagement.model.User;
import com.monitoring.sitemanagement.model.UserMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;


@Repository
public class UserDAOImpl implements UserDAO {

    @Autowired
    private JdbcTemplate jdbcTemplate;

    private final String INSERT_USER_QUERY = "INSERT INTO user(username, name, password) VALUES(?,?,?)";
    private final String GET_USER_BY_USERNAME_QUERY = "SELECT * FROM user where username = ?";
    private final String GET_USER_QUERY = "SELECT * FROM user";


    @Override
    public List<User> getAllUsers() {
        return jdbcTemplate.query(GET_USER_QUERY, new UserMapper());

    }

    @Override
    public Optional<User> findByUsername(String username) {
        return Optional.of(jdbcTemplate.queryForObject(GET_USER_BY_USERNAME_QUERY, new UserMapper(), new Object[] {username}));
    }

    @Override
    public int save(User user) {

        return jdbcTemplate.update(INSERT_USER_QUERY, new Object[] { user.getUsername(), user.getPassword(), user.getName() });

    }

}
