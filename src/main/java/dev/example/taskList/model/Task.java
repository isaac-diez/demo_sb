package dev.example.taskList.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class Task {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String title;
    private String description;
    private LocalDate dueDate;
    private LocalDate createdDate;
    //private Enum state;
    private boolean completed;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "USER_FK_ID")
    private User mappedUser;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "PROJECT_FK_ID")
    private Project mappedProject;

    @ManyToMany(cascade = {CascadeType.PERSIST, CascadeType.MERGE})
    @JoinTable(
            name = "TASK_TAG",
            joinColumns = @JoinColumn(name = "TASK_FK_ID"),
            inverseJoinColumns = @JoinColumn(name = "TAG_FK_ID")
    )
    private List<Tag> tags = new ArrayList<>();
}
