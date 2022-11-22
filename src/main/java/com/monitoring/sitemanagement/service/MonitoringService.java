package com.monitoring.sitemanagement.service;

import com.monitoring.sitemanagement.model.Monitoring;

import java.util.List;
import java.util.Map;

public interface MonitoringService {

    public List<Map<String, Object>> getAllMonitorings();
    Monitoring findById(int monitoring_id);
    public int countService();
    public int countEngine();
    public int countChart();

}
