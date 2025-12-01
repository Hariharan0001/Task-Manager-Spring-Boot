package com.example.TaskManager.dto;


import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class taskPostRequestDTO {
    private String title;
    private String description;
    private boolean completed;
}
