package com.example.TaskManager.clientDTO;


import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class userResponse {
    private Long userId;
    private String username;
    private String email;
}
