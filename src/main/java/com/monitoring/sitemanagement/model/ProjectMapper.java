package com.monitoring.sitemanagement.model;

import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

public class ProjectMapper implements RowMapper<Project> {

    @Override
    public Project mapRow(ResultSet rs, int rowNum) throws SQLException {

        Project project = new Project();
        project.setProject_id(rs.getInt("project_id"));
        project.setProject_name(rs.getString("project_name"));
        project.setKeterangan(rs.getString("keterangan"));
        project.setUsername(rs.getString("username"));
        return project;
    }
}
