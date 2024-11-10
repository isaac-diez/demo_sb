package dev.example.taskList.utilities;

import com.github.javafaker.Faker;
import dev.example.taskList.model.Project;
import dev.example.taskList.repository.ProjectRepository;
import jakarta.annotation.PostConstruct;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.Locale;
import java.util.UUID;

@Component
public class ProjectDataLoader {

    @Autowired
    private ProjectRepository projectRepository;

    @PostConstruct
    public void createFakeProjects() {

        if(projectRepository.count() == 0) {
            System.out.println(" 0 records at the database found");
            Faker faker = new Faker(new Locale("en-US"));

            int qty = 5;
            for(int i = 0; i < qty; i++) {
                Project project = new Project();
                project.setId((long) UUID.randomUUID().hashCode());
                project.setName(faker.animal().name());
                project.setDescription(faker.lorem().sentence());

                projectRepository.save(project);
            }
            System.out.println(qty + " fake Project records created");
        }

    }



}
