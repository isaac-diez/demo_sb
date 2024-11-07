package dev.example.taskList.repository;

import dev.example.taskList.model.AppUser;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.ArrayList;

public interface AppUserRepository extends JpaRepository<AppUser, Long> {

    int countByUsername(String username);

    ArrayList<AppUser> findByUsername(String username);



}
