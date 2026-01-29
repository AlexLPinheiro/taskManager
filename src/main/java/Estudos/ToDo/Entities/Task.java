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

    public Long getId() {
        return id;
    }

    public String getTaskName(){
        return taskName;
    }

    public void setTaskName(String taskName){
        this.taskName = taskName;
    }

    public LocalDate getCreationDate(){
        return creationDate;
    }

    public void setCreationDate(LocalDate creationDate){
        this.creationDate = creationDate;
    }

    public LocalDate getExpirationDate(){
        return expirationDate;
    }

    public void setExpirationDate(LocalDate expirationDate){
        this.expirationDate = expirationDate;
    }


}

