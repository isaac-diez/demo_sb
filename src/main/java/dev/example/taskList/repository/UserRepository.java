package dev.example.taskList.repository;

import dev.example.taskList.model.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.ArrayList;

public interface UserRepository extends JpaRepository<User, Long> {

    int countByName(String username);

    ArrayList<User> findByUsername(String username);



}
