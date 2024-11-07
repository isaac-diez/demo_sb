package dev.example.taskList.utilities;

import com.github.javafaker.Faker;
import dev.example.taskList.model.AppUser;
import dev.example.taskList.repository.AppUserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import java.util.Locale;
import java.util.UUID;

@Component
public class TagDataLoader {

    @Autowired
    private AppUserRepository appUserRepository;

    public void createFakeTagDataLoader() {
    }

}
