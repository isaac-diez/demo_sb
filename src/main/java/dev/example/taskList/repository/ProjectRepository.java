package dev.example.taskList.repository;

import dev.example.taskList.model.Project;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProjectRepository extends JpaRepository<Project, Long> {

    Project findByName(String name);
}
