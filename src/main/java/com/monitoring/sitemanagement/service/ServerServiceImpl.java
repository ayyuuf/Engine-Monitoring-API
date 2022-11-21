package com.monitoring.sitemanagement.service;

import com.monitoring.sitemanagement.dao.ServerDAOImpl;
import com.monitoring.sitemanagement.model.Server;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ServerServiceImpl implements ServerService{

    @Autowired
    private ServerDAOImpl serverDAO;

    @Override
    public List<Server> getAllServers() {
        return serverDAO.getAllServers();
    }

    @Override
    public Server findServerByServer_id(int server_id) {
        return serverDAO.findServerByServer_id(server_id);
    }

    @Override
    public void updateServer(Server server) {
        serverDAO.updateServer(server);

    }

    @Override
    public void addServer(Server server) {
        serverDAO.addServer(server);

    }

    @Override
    public void deleteServer(int server_id) {
        serverDAO.deleteServer(server_id);

    }
}
