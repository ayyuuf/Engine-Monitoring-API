package com.monitoring.sitemanagement.service;

import com.monitoring.sitemanagement.dao.MonitoringDAOImpl;
import com.monitoring.sitemanagement.model.Monitoring;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

@Service
public class MonitoringServiceImpl implements MonitoringService{

    @Autowired
    private MonitoringDAOImpl monitoringDAO;

    public List<Map<String, Object>> getAllMonitorings() {

        return monitoringDAO.getAllMonitorings();
    }

    @Override
    public Monitoring findById(int monitoring_id) {
        return monitoringDAO.findById(monitoring_id);
    }

    @Override
    public int countService() {
        return monitoringDAO.countService();
    }

    @Override
    public int countEngine() {
        return monitoringDAO.countEngine();
    }

    @Override
    public int countChart() {
        return monitoringDAO.countEngine();
    }
}
