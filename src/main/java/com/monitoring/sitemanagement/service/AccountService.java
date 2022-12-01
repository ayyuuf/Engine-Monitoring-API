package com.monitoring.sitemanagement.service;

import com.monitoring.sitemanagement.model.Account;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.List;

public interface AccountService {
    List<Account> getAllAccount();
    public void addAccount(Account account);
    public void updateAccount(Account account);
    public void deleteByScreen_name(String screen_name);
    public Account findByEmail(String email);
    public void readFile(MultipartFile file) throws IOException;
}
