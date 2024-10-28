package dev.example.taskList.repository;

import dev.example.taskList.model.Task;
import org.springframework.data.jpa.repository.JpaRepository;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;


public interface TaskRepository extends JpaRepository<Task, Integer> {

    Optional<Task> findByTitle(String title);
    List<Task> findByDueDate(LocalDate dueDate);
    Task findByDescription(String description);
    List<Task> findByCompleted(boolean completed);
    List<Task> findByCreatedDate(LocalDate createdDate);
    int countByCompleted(boolean completed);
    int countByDueDate(LocalDate dueDate);
    int countByTitle(String title);

}
