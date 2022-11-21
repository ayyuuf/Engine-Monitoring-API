package com.monitoring.sitemanagement.service;

import com.monitoring.sitemanagement.dao.UserDAOImpl;
import com.monitoring.sitemanagement.exception.AuthenticationFailException;
import com.monitoring.sitemanagement.exception.CustomException;
import com.monitoring.sitemanagement.model.AuthenticationToken;
import com.monitoring.sitemanagement.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.security.NoSuchAlgorithmException;
import java.util.List;
import java.util.Objects;
import java.util.Optional;

@Service
public class UserServiceImpl implements UserService {


    @Autowired
    private UserDAOImpl userDAO;

    @Autowired
    AuthenticationService authenticationService;

    @Override
    public List<User> getAllUsers() {
        return userDAO.getAllUsers();
    }

    @Override
    public User findByUsername(String username) {

        User user = new User();
        Optional<User> existingUser = userDAO.findByUsername(username);
        if (existingUser.isPresent())
            user = existingUser.get();
         throw new AuthenticationFailException("user is not valid");

         // hash password
        try {
            if (!user.getPassword().equals(hashPassword(user.getPassword()))) {
                throw new AuthenticationFailException("wrong password");
            }
        } catch (NoSuchAlgorithmException e) {
            e.printStackTrace();
        }
        AuthenticationToken token = authenticationService.getToken(user);

        // retrive the token

        if (Objects.isNull(token)) {
            throw new CustomException("token is not present");

        return new User();

    }

    @Override
    public void AddUser(User user) {
        userDAO.save(user);

        String encryptedpassword = AddUser.getPassword();

            try {
                encryptedpassword = hashPassword(AddUser.getPassword());
            } catch (NoSuchAlgorithmException e) {
                e.printStackTrace();
            }
            final AuthenticationToken authenticationToken = new AuthenticationToken(User);

            authenticationService.saveConfirmationToken(authenticationToken);
        }

    @Override
    public int count(){
            return userDAO.count();

        }

    }
