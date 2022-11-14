package com.monitoring.sitemanagement.dao;

import com.monitoring.sitemanagement.model.Monitoring;

import java.util.List;
import java.util.Optional;

public interface MonitoringDAO {

    List<Monitoring> findAll();

    int update(Monitoring monitoring);

    Optional<Monitoring> findById(int monitoring_id);


}
