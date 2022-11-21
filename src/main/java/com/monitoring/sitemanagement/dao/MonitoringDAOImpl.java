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
    private final String UPDATE_MONITORING_QUERY = "UPDATE * WHERE monitoring_id=?";
    private final String GET_MONITORING_BY_ID_QUERY = "SELECT * FROM monitoring where monitoring_id = ?";

    @Override
    public List<Monitoring> findAll() {
        return jdbcTemplate.query(GET_MONITORING_QUERY, new MonitoringMapper());
    }

    @Override
    public int update(Monitoring monitoring) {
        return jdbcTemplate.update(UPDATE_MONITORING_QUERY, new Object[] {monitoring.getUsername(), monitoring.getProject_id(),monitoring.getServer_id(), monitoring.getName(), monitoring.getType(),
        monitoring.getPort(), monitoring.getHaproxy(), monitoring.getHaproxy_port(), monitoring.getPath(), monitoring.getGit_url(), monitoring.getRunning_on(),monitoring.getRunning_command(), monitoring.getLast_update()});
    }

    @Override
    public Optional<Monitoring> findById(int monitoring_id) {
        return java.util.Optional.of(jdbcTemplate.queryForObject(GET_MONITORING_BY_ID_QUERY, new MonitoringMapper(), new Object[] {monitoring_id}));
    }

    @Override
    public int countService() {
        String query = "SELECT COUNT(type) FROM monitoring where type = service ";
        return jdbcTemplate.queryForObject(query, Integer.class);
    }

    @Override
    public int countEngine() {
        String query = "SELECT COUNT(type) FROM monitoring where type = engine";
        return jdbcTemplate.queryForObject(query, Integer.class);
    }
}
