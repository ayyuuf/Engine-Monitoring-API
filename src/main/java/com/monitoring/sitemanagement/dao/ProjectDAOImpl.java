package com.monitoring.sitemanagement.dao;

import com.monitoring.sitemanagement.model.Project;
import com.monitoring.sitemanagement.model.ProjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Repository
@Transactional
public class ProjectDAOImpl implements ProjectDAO{

    @Autowired
    private JdbcTemplate jdbcTemplate;

    @Override
    public Project findProjectByProject_id(Integer project_id) {
        String query = "SELECT * FROM project WHERE project_id = ?";
        RowMapper<Project> rowMapper = new BeanPropertyRowMapper<Project>(Project.class);
        Project project= jdbcTemplate.queryForObject(query, rowMapper, project_id);
        return project;
    }

    @Override
    public void updateProject(Project project) {
        String query = "UPDATE project SET project_name=?, keterangan=?, username=? WHERE project_id=?";
        jdbcTemplate.update(query,project.getProject_name(),project.getKeterangan(),project.getUsername(), project.getProject_id());

    }

    @Override
    public void addProject(Project project) {
        String query = ("INSERT INTO project( project_name, keterangan, username) VALUES('"+project.getProject_name()+"','"+project.getKeterangan()+"','"+project.getUsername()+"')");
        jdbcTemplate.update(query);

    }


    @Override
    public void deleteProject(int project_id) {
        String query = "DELETE FROM server WHERE project_id=?";
        jdbcTemplate.update(query, project_id);
    }

    @Override
    public List<Project> getAllProjects() {
        String query = "SELECT * from project";
        RowMapper<Project> rowMapper = new ProjectMapper();
        List<Project> list = jdbcTemplate.query(query, rowMapper);
        return list;
    }
}
