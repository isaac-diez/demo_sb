package dev.example.taskList.service;

import dev.example.taskList.model.Project;
import dev.example.taskList.repository.ProjectRepository;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;
import java.util.Optional;

public class ProjectServiceImpl implements ProjectService {

    @Autowired
    private ProjectRepository projectRepository;

    @Override
    public Project createProject(Project project) {
        return projectRepository.save(project);
    }

    @Override
    public Project getProjectById(Long id) {
        return projectRepository.findById(id).orElse(null);
    }

    @Override
    public List<Project> getAllProjects() {
        return projectRepository.findAll();
    }

    @Override
    public Project updateProject(Long id, Project project) {
        if (projectRepository.existsById(id)) {
            project.setId(id);
            return projectRepository.save(project);
        }
        return null;
    }

    @Override
    public boolean deleteProject(Long id) {
        projectRepository.deleteById(id);
        Optional<Project> project = projectRepository.findById(id);
        return project.isEmpty()
            ? false : true;
    }

    @Override
    public int countProject() {
        return (int) projectRepository.count();
    }
}
