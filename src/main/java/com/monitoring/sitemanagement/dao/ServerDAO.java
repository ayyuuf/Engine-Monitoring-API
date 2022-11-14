package com.monitoring.sitemanagement.dao;

import com.monitoring.sitemanagement.model.Server;

import java.util.List;


public interface ServerDAO {

    List<Server> getAllServers();
    public Server findServerByServer_id(Integer server_id);
    public void updateServer( Server server);
    public void addServer(Server server);
    public void deleteServer(int server_id);


}
