package dev.example.taskList.service;

import dev.example.taskList.model.Project;

import java.util.List;

public interface ProjectService {
    Project createProject(Project project);
    Project getProjectById(Long id);
    List<Project> getAllProjects();
    Project updateProject(Long id, Project project);
    boolean deleteProject(Long id);
    int countProject();
}
