package com.monitoring.sitemanagement.service;

import com.monitoring.sitemanagement.dao.AccountDAO;
import com.monitoring.sitemanagement.model.Account;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;

@Service
public class AccountServiceImpl implements AccountService{

    @Autowired
    private AccountDAO accountDAO;

    @Override
    public List<Account> getAllAccount() {
        return accountDAO.getAllAccount();
    }

    @Override
    public void addAccount(Account account) {
        accountDAO.addAccount(account);


    }

    @Override
    public void updateAccount(Account account) {
        accountDAO.updateAccount(account);
    }

    @Override
    public void deleteByScreen_name(String screen_name) {
        accountDAO.deleteByScreen_name(screen_name);
    }

    @Override
    public Account findByEmail(String email) {
        return accountDAO.findByEmail(email);
    }

    @Override
    public void uploadFile(MultipartFile file) {
        accountDAO.uploadFile(file);
    }


}
