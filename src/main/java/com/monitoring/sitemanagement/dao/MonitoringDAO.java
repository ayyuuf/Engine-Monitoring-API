package com.monitoring.sitemanagement.dao;

import com.monitoring.sitemanagement.model.Monitoring;

import java.util.List;
import java.util.Map;

public interface MonitoringDAO {

    List<Map<String, Object>> getAllMonitorings();

    Monitoring findById(int monitoring_id);

    public int countService();

    public int countEngine();

    public int countChart();

}
