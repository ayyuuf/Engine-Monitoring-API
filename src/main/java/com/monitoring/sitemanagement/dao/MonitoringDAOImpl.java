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
    public void addMonitoring(Monitoring monitoring) {
        String query = ("INSERT INTO monitoring (username, project_id, server_id, name, type, port, haproxy, haproxy_port, path, git_url, running_on, running_command, last_update) VALUES ('"+monitoring.getUsername()+"','"+monitoring.getProject_id()+"', '"+monitoring.getServer_id()+"','"+monitoring.getName()+"','"+monitoring.getType()+"', '"+monitoring.getPort()+"', '"+monitoring.getHaproxy()+"', '"+monitoring.getHaproxy_port()+"','"+monitoring.getPath()+"', '"+monitoring.getGit_url()+"', '"+monitoring.getRunning_on()+"', '"+monitoring.getRunning_command()+"', '"+monitoring.getLast_update()+"')");
        System.out.println(query);
        jdbcTemplate.update(query);

    }

    @Override
    public void updateMonitoring(Monitoring monitoring) {
        String query =("UPDATE monitoring SET username=?, project_id=?, server_id=?, name=?, type=?, port=?,haproxy=?, haproxy_port=?, path=?, git_url=?, running_on=?, running_command=?, last_update=? WHERE monitoring_id=?");
        jdbcTemplate.update(query, monitoring.getUsername(),monitoring.getProject_id(), monitoring.getServer_id(), monitoring.getName(), monitoring.getType(),monitoring.getPort(), monitoring.getHaproxy(), monitoring.getHaproxy_port(),monitoring.getPath(),monitoring.getGit_url(), monitoring.getRunning_on(), monitoring.getRunning_command(), monitoring.getLast_update(),monitoring.getMonitoring_id());
    }

    @Override
    public void deleteMonitoring(int monitoring_id) {
        String query = "DELETE FROM monitoring WHERE monitoring_id=?";
        jdbcTemplate.update(query, monitoring_id);
    }
}
