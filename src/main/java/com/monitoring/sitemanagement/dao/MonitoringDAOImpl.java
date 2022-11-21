package com.monitoring.sitemanagement.dao;

import com.monitoring.sitemanagement.model.Monitoring;
import com.monitoring.sitemanagement.model.MonitoringMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public class MonitoringDAOImpl implements MonitoringDAO{

    @Autowired
    private JdbcTemplate jdbcTemplate;

    private final String GET_MONITORING_QUERY = "SELECT * FROM monitoring";
    private final String GET_MONITORING_BY_ID_QUERY = "SELECT * FROM monitoring where monitoring_id = ?";

    @Override
    public List<Monitoring> getMonitorings() {
        return jdbcTemplate.query(GET_MONITORING_QUERY, new MonitoringMapper());
    }

    @Override
    public Optional<Monitoring> findById(int monitoring_id) {
        return java.util.Optional.of(jdbcTemplate.queryForObject(GET_MONITORING_BY_ID_QUERY, new MonitoringMapper(), new Object[] {monitoring_id}));
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
