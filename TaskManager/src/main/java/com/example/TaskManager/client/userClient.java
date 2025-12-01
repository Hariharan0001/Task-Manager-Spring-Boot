package com.example.TaskManager.client;

import com.example.TaskManager.clientDTO.userResponse;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@FeignClient(name = "user")
public interface userClient {

    @GetMapping("/user/{id}")
    userResponse getUserById(@PathVariable Long id);
}
