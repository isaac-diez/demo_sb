package dev.example.taskList.utilities;

import com.github.javafaker.Faker;
import dev.example.taskList.model.AppUser;
import dev.example.taskList.repository.AppUserRepository;
import jakarta.annotation.PostConstruct;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import java.util.Locale;
import java.util.UUID;

@Component
public class AppUserDataLoader {

    @Autowired
    private AppUserRepository appUserRepository;

    @PostConstruct
    public void createFakeAppUsers() {

        if (appUserRepository.count() == 0) {
        System.out.println(" 0 records at the database found");
            Faker faker = new Faker(new Locale("en-US"));

            int qty = 10;
            for (int i = 0; i < qty; i++) {
                AppUser appUser = new AppUser(
                        (long) UUID.randomUUID().hashCode(),
                        faker.name().username(),
                        faker.internet().emailAddress()

                );

                appUserRepository.save(appUser);
            }

            System.out.println(qty + " fake AppUser records created");


        }

    }

}

