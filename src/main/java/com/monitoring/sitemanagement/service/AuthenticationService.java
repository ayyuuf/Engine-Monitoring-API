package com.monitoring.sitemanagement.service;

import com.monitoring.sitemanagement.dao.TokenRepository;
import com.monitoring.sitemanagement.model.AuthenticationToken;
import com.monitoring.sitemanagement.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AuthenticationService {

    @Autowired
    TokenRepository tokenRepository;

    public void saveConfirmationToken(AuthenticationToken authenticationToken) {
        tokenRepository.save(authenticationToken);
    }

    public AuthenticationToken getToken(User user) {
        return tokenRepository.findByUsername(user);
    }
}
