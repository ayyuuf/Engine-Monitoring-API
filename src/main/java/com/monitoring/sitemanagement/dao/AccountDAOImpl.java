package com.monitoring.sitemanagement.dao;

import com.monitoring.sitemanagement.model.Account;
import com.monitoring.sitemanagement.model.AccountMapper;
import org.apache.commons.csv.CSVFormat;
import org.apache.commons.csv.CSVParser;
import org.apache.commons.csv.CSVRecord;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;
import org.springframework.ui.ModelMap;
import org.springframework.web.multipart.MultipartFile;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

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
    public void readFile(MultipartFile file) throws IOException {
            BufferedReader fileReader = new BufferedReader(
                    new InputStreamReader(file.getInputStream(), "UTF-8"));
            CSVParser csvParser = CSVFormat.EXCEL.withFirstRecordAsHeader().withDelimiter(';').parse(fileReader);
            List<Map<String,Object>> list = new ArrayList<>();

            Iterable<CSVRecord> csvRecords = csvParser.getRecords();

            for (CSVRecord csvRecord : csvRecords) {
                Map<String, Object> m = new HashMap<>();

                m.put("screen_name", csvRecord.get(0));
                m.put("email", csvRecord.get(1));
                m.put("phone_no", csvRecord.get(2));
                m.put("password", csvRecord.get(3));
                m.put("status", csvRecord.get(4));
                m.put("type", csvRecord.get(5));
                m.put("app_name", csvRecord.get(6));
                m.put("consumer_key", csvRecord.get(7));
                m.put("consumer_secret", csvRecord.get(8));
                m.put("access_token", csvRecord.get(9));
                m.put("access_token_secret", csvRecord.get(10));
                m.put("username", csvRecord.get(11));
                m.put("description", csvRecord.get(12));

                list.add(m);}
        for (Map<String,Object> data:
             list)
        {
            String query = "INSERT INTO account( screen_name, email, phone_no, password, status, type, app_name, consumer_key, consumer_secret, access_token, access_token_secret, username, description) VALUES('"+data.get("screen_name").toString()+"','"+data.get("email").toString()+"','"+Integer.parseInt(data.get("phone_no").toString())+"','"+data.get("password").toString()+"','"+data.get("status").toString()+"','"+data.get("type").toString()+"','"+data.get("app_name").toString()+"','"+data.get("consumer_key").toString()+"','"+data.get("consumer_secret").toString()+"','"+data.get("access_token").toString()+"', '"+data.get("access_token_secret").toString()+"', '"+data.get("username").toString()+"', '"+data.get("description").toString()+"')";
            System.out.println(query);
            jdbcTemplate.update(query);
        }
    }


}
