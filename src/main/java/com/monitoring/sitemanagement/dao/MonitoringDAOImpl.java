package com.monitoring.sitemanagement.dao;

import com.monitoring.sitemanagement.model.Monitoring;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Map;

@Repository
public class MonitoringDAOImpl implements MonitoringDAO{

    @Autowired
    private JdbcTemplate jdbcTemplate;


    @Override
    public List<Map<String, Object>> getAllMonitorings() {
        String query = "SELECT * from monitoring";
        return jdbcTemplate.queryForList(query);
//        RowMapper<Monitoring> rowMapper = new MonitoringMapper();
//        List<Monitoring> list = jdbcTemplate.query(query, rowMapper);
//        System.out.println(list);
//        return list;
    }

    @Override
    public Monitoring findById(int monitoring_id) {
        String query = "SELECT * FROM monitoring WHERE monitoring_id = ?";
        RowMapper<Monitoring> rowMapper = new BeanPropertyRowMapper<Monitoring>(Monitoring.class);
        Monitoring monitoring= jdbcTemplate.queryForObject(query, rowMapper, monitoring_id);
        return monitoring;
    }

    @Override
    public int countService() {
        String query = "SELECT COUNT(type) FROM monitoring where type = 1 ";
        return jdbcTemplate.queryForObject(query, Integer.class);
    }

    @Override
    public int countEngine() {
        String query = "SELECT COUNT(type) FROM monitoring where type = 2";
        return jdbcTemplate.queryForObject(query, Integer.class);
    }

    @Override
    public int countChart() {
        String query = "SELECT type, COUNT(*) from monitoring GROUP BY type";
        return jdbcTemplate.queryForObject(query, Integer.class);
    }
}
