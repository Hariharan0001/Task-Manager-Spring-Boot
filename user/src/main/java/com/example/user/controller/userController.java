package com.example.user.controller;

import com.example.user.DTO.userPatchRequestDTO;
import com.example.user.DTO.userResponseDTO;
import com.example.user.service.userService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/user")
public class userController {

    @Autowired
    private userService userService;

    @GetMapping("/{id}")
    public userResponseDTO getUserBYId(@PathVariable Long id){
        return userService.getUserById(id);
    }

    @PatchMapping("/{id}")
    public String userPatch(@PathVariable Long id, @RequestBody userPatchRequestDTO user){
        return userService.userPatch(id,user);
    }
}
