package dev.example.taskList.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class AppUser {

    @Id
    @GeneratedValue (strategy = GenerationType.IDENTITY)
    private Long id;
    private String username;
    private String email;

    @OneToMany(mappedBy = "mappedAppUser", cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    private List<Task> tasks;


}
