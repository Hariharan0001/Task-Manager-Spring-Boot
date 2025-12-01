package com.example.TaskManager.controller;

import com.example.TaskManager.dto.taskGetAllResponseDTO;
import com.example.TaskManager.dto.taskPatchRequestDTO;
import com.example.TaskManager.dto.taskPostRequestDTO;
import com.example.TaskManager.dto.taskSingleGetResponseDTO;
import com.example.TaskManager.model.Task;
import com.example.TaskManager.service.taskService;
import jakarta.websocket.server.PathParam;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.math.BigDecimal;
import java.math.BigInteger;
import java.util.List;

@RestController
@RequestMapping("/task")
public class taskController {

    @Autowired
    private taskService taskService;

    @GetMapping("/")
    public List<taskGetAllResponseDTO> getAllTask(){
        List<Task> answer = taskService.getAllTask();
        return answer.stream().map(task -> new taskGetAllResponseDTO(
                task.getId(),
                task.getTitle(),
                task.getDescription(),
                task.getCompleted()
        )).toList();
    }

    @GetMapping("/{id}")
    public taskSingleGetResponseDTO singleGet(@PathVariable Long id){
        return taskService.singleGetWithUser(id);
    }

    @PostMapping("/addTask")
    public String addTask(@RequestBody taskPostRequestDTO task){
        return taskService.addTask(task);
    }

    @DeleteMapping("/{id}")
    public String deleteTask(@PathVariable Long id){
        return taskService.deleteTask(id);
    }

    @PatchMapping("/{id}")
    public String taskPatch(@PathVariable Long id, @RequestBody taskPatchRequestDTO task){
        return taskService.taskPatch(id, task);
    }
}
