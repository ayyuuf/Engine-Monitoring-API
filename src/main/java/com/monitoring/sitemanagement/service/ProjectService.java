package com.monitoring.sitemanagement.service;

import com.monitoring.sitemanagement.model.Project;

import java.util.List;

public interface ProjectService {


    List<Project> getAllProjects();

    Project findProjectByProject_id(int project_id);

    void updateProject(Project project);

    void addProject(Project project);

    void deleteProject(int project_id);
}
