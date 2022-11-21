package com.monitoring.sitemanagement.dao;

import com.monitoring.sitemanagement.model.AuthenticationToken;
import com.monitoring.sitemanagement.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TokenRepository extends JpaRepository<AuthenticationToken, Integer> {

    AuthenticationToken findByUsername (User user);

}
