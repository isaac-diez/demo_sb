package dev.example.taskList.repository;

import dev.example.taskList.model.AppUser;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;

@Repository
public interface AppUserRepository extends JpaRepository<AppUser, Long> {

    int countByUsername(String username);

    long count();

    ArrayList<AppUser> findByUsername(String username);



}
