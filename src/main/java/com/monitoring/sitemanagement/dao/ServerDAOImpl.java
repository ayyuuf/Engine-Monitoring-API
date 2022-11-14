package com.monitoring.sitemanagement.dao;

import com.monitoring.sitemanagement.model.Server;
import com.monitoring.sitemanagement.model.ServerMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Transactional
@Repository
public class ServerDAOImpl implements  ServerDAO{

    @Autowired
    private JdbcTemplate jdbcTemplate;


    @Override
    public List<Server> getAllServers() {
        String query = "SELECT * from server";
        RowMapper<Server> rowMapper = new ServerMapper();
        List<Server> list = jdbcTemplate.query(query, rowMapper);
        return list;
    }

    @Override
    public Server findServerByServer_id(Integer server_id) {
        String query = "SELECT * FROM server WHERE server_id = ?";
        RowMapper<Server> rowMapper = new BeanPropertyRowMapper<Server >(Server.class);
        Server server= jdbcTemplate.queryForObject(query, rowMapper, server_id);
        return server;
    }

    @Override
    public void updateServer( Server server) {
        String query = "UPDATE server SET server_ip=?, keterangan=?, project_id=?, username=? WHERE server_id=?";
        jdbcTemplate.update(query,server.getServer_ip(),server.getKeterangan(),server.getProject_id(),server.getUsername(),server.getServer_id());

    }

    @Override
    public void addServer(Server server) {
        String query = ("INSERT INTO server( server_ip, keterangan, project_id, username) VALUES('"+server.getServer_ip()+"','"+server.getKeterangan()+"',"+server.getProject_id()+",'"+server.getUsername()+"')");
        jdbcTemplate.update(query);

    }

    @Override
    public void deleteServer(int server_id) {
        String query = "DELETE FROM server WHERE server_id=?";
        jdbcTemplate.update(query, server_id);
    }

}
