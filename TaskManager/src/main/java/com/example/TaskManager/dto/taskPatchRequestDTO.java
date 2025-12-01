package com.example.TaskManager.dto;


import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class taskPatchRequestDTO {
    private String title;
    private String description;
    private Boolean completed;
    private Long userId;

}
