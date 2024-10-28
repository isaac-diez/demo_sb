package dev.example.taskList.service;

import dev.example.taskList.model.Task;
import dev.example.taskList.repository.TaskRepository;
import org.springframework.beans.factory.annotation.Autowired;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

public class TaskServiceImpl implements TaskService{

    @Autowired
    private TaskRepository taskRepository;

    @Override
    public List<Task> getAllTasks() {
        return taskRepository.findAll();
    }

    @Override
    public Task getTaskByTitle(String title) {
        return taskRepository.findByTitle(title).orElse(null);
    }

    @Override
    public List<Task> getTaskByDueDate(LocalDate dueDate) {
        return taskRepository.findByDueDate(dueDate);
    }

    @Override
    public List<Task> getTaskByCreatedDate(LocalDate createdDate) {
        return taskRepository.findByCreatedDate(createdDate);
    }

    @Override
    public Task createTask(Task task) {
        task.setId(Integer.parseInt(UUID.randomUUID().toString().substring(0, 8)));
        return taskRepository.save(task);
    }


    @Override
    public Task updateTask(String title, Task taskDetails) {

        Task task = taskRepository.findByTitle(title).orElse(null);
        if (task != null) {
            if (taskDetails.getDescription() != null) {
                task.setDescription(taskDetails.getDescription());
            }
            if (taskDetails.getDueDate() != null) {
                task.setDueDate(taskDetails.getDueDate());
            }
            if (!taskDetails.getCompleted()) {
                task.setCompleted(taskDetails.getCompleted());
            }

            return taskRepository.save(task);
        }
        return null;
    }

    @Override
    public boolean deleteTask(int id) {
        taskRepository.deleteById(id);
        Optional<Task> task = taskRepository.findById(id);
        return task.isEmpty()
            ? false : true;


    }

    @Override
    public int countTask() {
        return (int) taskRepository.count();
    }
}
