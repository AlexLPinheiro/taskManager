package Estudos.ToDo.Entities;

import jakarta.persistence.*;

import java.time.LocalDate;

@Entity
@Table
public class Task {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "task_generate")
    private Long id;
    private String taskName;
    private LocalDate creationDate;
    private LocalDate expirationDate;

    @ManyToOne
    @JoinColumn(name="category_id")
    private Category category;

    public Task (String taskName, LocalDate creationDate, LocalDate expirationDate){
        this.taskName = taskName;
        this.creationDate = creationDate;
        this.expirationDate = expirationDate;
    }

    public Task(){}

    public String getTaskName(){
        return taskName;
    }


}

