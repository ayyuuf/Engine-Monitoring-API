package com.monitoring.sitemanagement.model;

import ch.qos.logback.classic.util.LogbackMDCAdapter;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

public class AccountMapper implements RowMapper<Account> {
    @Override
    public Account mapRow(ResultSet rs, int rowNum) throws SQLException {
        LogbackMDCAdapter csvRecord = null;
        Account account = new Account(csvRecord.get("screen_name"), csvRecord.get("email"), csvRecord.get("phone_no"), csvRecord.get("password"), csvRecord.get("status"), csvRecord.get("type"), csvRecord.get("app_name"), csvRecord.get("consumer_key"), csvRecord.get("consumer_secret"), csvRecord.get("access_token"), csvRecord.get("access_token_secret"), csvRecord.get("username"), csvRecord.get("description"));
        account.setScreen_name(rs.getString("screen_name"));
        account.setEmail(rs.getString("email"));
        account.setPhone_no(rs.getLong("phone_no"));
        account.setPassword(rs.getString("password"));
        account.setStatus(rs.getString("status"));
        account.setType(rs.getString("type"));
        account.setApp_name(rs.getString("app_name"));
        account.setConsumer_key(rs.getString("consumer_key"));
        account.setConsumer_secret(rs.getString("consumer_secret"));
        account.setAccess_token(rs.getString("access_token"));
        account.setAccess_token_secret(rs.getString("access_token_secret"));
        account.setUsername(rs.getString("username"));
        account.setDescription(rs.getString("description"));
        return account;
    }
}
