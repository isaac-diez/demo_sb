package dev.example.taskList.utilities;

import com.github.javafaker.Faker;
import dev.example.taskList.model.AppUser;
import dev.example.taskList.model.Tag;
import dev.example.taskList.repository.AppUserRepository;
import dev.example.taskList.repository.TagRepository;
import jakarta.annotation.PostConstruct;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import java.util.Locale;
import java.util.UUID;

@Component
public class TagDataLoader {

    @Autowired
    private TagRepository tagRepository;

    @PostConstruct
    public void createFakeTags() {

        if (tagRepository.count() == 0) {
            System.out.println(" 0 records at the database found");
            Faker faker = new Faker(new Locale("en-US"));

            int qty = 10;
            for (int i = 0; i < qty; i++) {
                Tag tag = new Tag();

                Long id = (long) UUID.randomUUID().hashCode();
                String name = faker.superhero().name();

                tagRepository.save(tag);
            }
            System.out.println(qty + " fake Tag records created");
        }
    }

}
