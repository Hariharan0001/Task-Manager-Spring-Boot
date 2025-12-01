package com.example.TaskManager.model;


import jakarta.persistence.*;
import lombok.Builder;
import lombok.Data;

import java.math.BigInteger;

@Entity
@Data
@Table(name = "tasks")
public class Task {

    @Id
    @GeneratedValue
    private Long id;

    private String title;
    private String description;
    private Boolean completed;
    private Long userId;
    private Boolean deleted;
}
