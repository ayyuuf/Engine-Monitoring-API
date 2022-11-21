package com.monitoring.sitemanagement.dao;

import com.monitoring.sitemanagement.model.Monitoring;

import java.util.List;
import java.util.Optional;

public interface MonitoringDAO {

    List<Monitoring> findAll();

   public int update(Monitoring monitoring);

    Optional<Monitoring> findById(int monitoring_id);

    public int countService();

    public int countEngine();

    public int countChart();

}
