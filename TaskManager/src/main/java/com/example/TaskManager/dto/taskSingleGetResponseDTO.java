package com.example.TaskManager.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigInteger;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class taskSingleGetResponseDTO {
    private Long id;
    private String title;
    private String description;
    private boolean completed;
    private String userName;
    private String email;
}
