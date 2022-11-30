package com.monitoring.sitemanagement.dao;

import com.monitoring.sitemanagement.model.Account;
import com.monitoring.sitemanagement.model.AccountMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;

@Repository
public class AccountDAOImpl implements AccountDAO{

    @Autowired
    private JdbcTemplate jdbcTemplate;

    @Override
    public List<Account> getAllAccount() {
        String query = "SELECT * FROM account";
        RowMapper<Account> rowMapper = new AccountMapper();
        List<Account> list = jdbcTemplate.query(query, rowMapper);
        return list;
    }


    @Override
    public void addAccount(Account account) {
        String query = ("INSERT INTO account( screen_name, email, phone_no, password, status, type, app_name, consumer_key, consumer_secret, access_token, access_token_secret, username, description) VALUES('"+account.getScreen_name()+"','"+account.getEmail()+"','"+account.getPhone_no()+"','"+account.getPassword()+"','"+account.getStatus()+"','"+account.getType()+"','"+account.getApp_name()+"','"+account.getConsumer_key()+"','"+account.getConsumer_secret()+"','"+account.getAccess_token()+"', '"+account.getAccess_token_secret()+"', '"+account.getUsername()+"', '"+account.getDescription()+"')");
        System.out.println(query);
        jdbcTemplate.update(query);

    }

    @Override
    public void updateAccount(Account account) {
        String query = "UPDATE account SET  email= ?, phone_no=? , password =?, status =?, type=? ,app_name=? ,consumer_key=? ,consumer_secret=? ,access_token=?, access_token_secret=? , username=?, description=?";
        jdbcTemplate.update(query, account.getEmail(), account.getPhone_no(), account.getPassword(), account.getStatus(), account.getType(),account.getApp_name(), account.getConsumer_key(), account.getConsumer_secret(), account.getAccess_token(),account.getAccess_token_secret(), account.getUsername(), account.getDescription());


    }

    @Override
    public void deleteByScreen_name(String screen_name) {
        String query = "DELETE FROM account WHERE screen_name=?";
        jdbcTemplate.update(query, screen_name);

    }

    @Override
    public Account findByEmail(String email) {
        String query = "SELECT * FROM account WHERE email = ?";
        RowMapper<Account> rowMapper = new BeanPropertyRowMapper<Account>(Account.class);
        Account account= jdbcTemplate.queryForObject(query, rowMapper, email);
        return account;
    }

    @Override
    public void uploadFile(MultipartFile file) {
    String query = "INSERT INTO account (screen_name, email, phone_no, password, status, type, app_name, consumer_key, consumer_secret, access_token, access_token_secret, username, description)VALUES(:screen_name, :email, :phone_no, :password, :status, :type, :app_name, :consumer_key, :consumer_secret, :access_token, :access_token_secret, :username, :description)";
    System.out.println(query);
    jdbcTemplate.update(query);
    }


}
