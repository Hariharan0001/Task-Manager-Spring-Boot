package com.example.TaskManager.dto;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.math.BigInteger;

@Data
@AllArgsConstructor
public class taskGetAllResponseDTO {

    private Long id;
    private String title;
    private String description;
    private boolean completed;

}
