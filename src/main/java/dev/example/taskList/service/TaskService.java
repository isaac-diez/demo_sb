package dev.example.taskList.service;

import dev.example.taskList.model.Task;

import java.time.LocalDate;
import java.util.List;

public interface TaskService {

    List<Task> getAllTasks();
    Task getTaskByTitle(String title);
    List<Task> getTaskByDueDate(LocalDate dueDate);
    List<Task> getTaskByCreatedDate(LocalDate createdDate);
    Task createTask(Task task);
    Task updateTask(String title, Task taskDetails);
    boolean deleteTask(int id);
    int countTask();

}
