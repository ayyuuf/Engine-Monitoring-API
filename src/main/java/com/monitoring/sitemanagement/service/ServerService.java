package com.monitoring.sitemanagement.service;

import com.monitoring.sitemanagement.model.Server;

import java.util.List;

public interface ServerService {

    List<Server> getAllServers();
    public Server findServerByServer_id(int server_id);
    public void updateServer( Server server);
    public void addServer(Server server);
    public void deleteServer(int server_id);
}
