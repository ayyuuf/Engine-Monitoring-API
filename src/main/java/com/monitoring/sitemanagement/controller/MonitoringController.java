package com.monitoring.sitemanagement.controller;

import com.monitoring.sitemanagement.model.Monitoring;
import com.monitoring.sitemanagement.model.Project;
import com.monitoring.sitemanagement.service.MonitoringServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin(origins = "*")
@RequestMapping("/monitoring")
public class MonitoringController {

    @Autowired
    private MonitoringServiceImpl monitoringService;

    @GetMapping("/")
    public ResponseEntity<?> getMonitorings() {

        List<Monitoring> monitorings = monitoringService.getMonitorings();
        return new ResponseEntity<>(monitorings, HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<?> getMonitoringById(@PathVariable("id") int monitoring_id) {

        Monitoring monitoring = monitoringService.getMonitoringById(monitoring_id);
        return new ResponseEntity<>(monitoring, HttpStatus.OK);
    }

    @GetMapping("/countService")
    public ResponseEntity<?> countService(){

        int monitoring= monitoringService.countService();
        return new ResponseEntity<>(monitoring, HttpStatus.OK);
    }

    @GetMapping("/countEngine")
    public ResponseEntity<?> countEngine(){

        int monitoring= monitoringService.countEngine();
        return new ResponseEntity<>(monitoring, HttpStatus.OK);
    }

    @GetMapping("/countChart")
    public ResponseEntity<?> countChart(){

        int monitoring= monitoringService.countChart();
        return new ResponseEntity<>(monitoring, HttpStatus.OK);
    }

}
