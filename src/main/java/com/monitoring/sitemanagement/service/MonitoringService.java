package com.monitoring.sitemanagement.service;

import com.monitoring.sitemanagement.model.Monitoring;

import java.util.List;

public interface MonitoringService {

    public List<Monitoring> getMonitorings();
    public Monitoring getMonitoringById(int id);
    public int countService();
    public int countEngine();
    public int countChart();

}
