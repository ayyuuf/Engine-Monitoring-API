package com.monitoring.sitemanagement.dao;

import com.monitoring.sitemanagement.model.Project;

import java.util.List;

public interface ProjectDAO {

    Project findProjectByProject_id(Integer Project_id);

    void updateProject(Project project);

    void addProject(Project project);

    void deleteProject(int project_id);

    List<Project> getAllProjects();
}
