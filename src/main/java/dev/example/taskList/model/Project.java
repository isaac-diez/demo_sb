package dev.example.taskList.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor

public class Project {

        @Id
        @GeneratedValue(strategy = GenerationType.IDENTITY)
        private Long id;
        private String name;
        private String description;

        @OneToMany(mappedBy = "mappedProject", cascade = CascadeType.ALL, fetch = FetchType.EAGER)
        private List<Task> tasks;
}
