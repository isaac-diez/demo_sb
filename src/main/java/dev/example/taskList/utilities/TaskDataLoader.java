package dev.example.taskList.utilities;

import com.github.javafaker.Faker;
import dev.example.taskList.model.AppUser;
import dev.example.taskList.model.Task;
import dev.example.taskList.repository.AppUserRepository;
import dev.example.taskList.repository.TaskRepository;
import jakarta.annotation.PostConstruct;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.UUID;
import java.util.concurrent.TimeUnit;

@Component
public class TaskDataLoader {

    @Autowired
    private TaskRepository taskRepository;

    @Autowired
    private AppUserRepository appUserRepository;

    @PostConstruct
    public void createFakeTasks() {

        if (taskRepository.count() == 0) {
            System.out.println(" 0 records at the database found");
            Faker faker = new Faker();

            // Obtener todos los AppUser existentes para asignarlos aleatoriamente
            ArrayList<AppUser> appUsers = (ArrayList<AppUser>) appUserRepository.findAll();

            if (appUsers.isEmpty()) {
                System.out.println("No AppUsers found to assign to tasks. Please add users first.");
                return; // Detener si no hay usuarios
            }

            for (int i = 0; i < 10; i++) {
                Task task = new Task();
                task.setId(UUID.randomUUID().hashCode());
                task.setTitle(faker.book().title());
                task.setDescription(faker.book().title());
                task.setDueDate(faker.date().future(30, TimeUnit.DAYS));
                task.setCreatedDate(faker.date().past(30, TimeUnit.DAYS));
                task.setCompleted(faker.bool().bool());

                // Asignar un AppUser aleatorio de la lista
                AppUser mappedAppUser = appUsers.get(faker.random().nextInt(appUsers.size()));
                task.setMappedAppUser(mappedAppUser);

            taskRepository.save(task);
        }

        System.out.println("10 fake Task records created");}
    }
}
