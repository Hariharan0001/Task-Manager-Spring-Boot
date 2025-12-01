package com.example.user.DTO;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class userPatchRequestDTO {
    private Long userId;
    private String userName;
    private String email;
}
