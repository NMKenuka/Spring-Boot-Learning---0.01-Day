package dev.spring.boot.HelloWorld.Entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import lombok.Data;
import jakarta.persistence.*;

@Entity
@Data
public class Todo {
    @Id
    @GeneratedValue
    private Long id;

    private String title;
    private String description;
    private Boolean isCompleted;
}

