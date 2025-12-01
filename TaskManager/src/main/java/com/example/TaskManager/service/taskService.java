package com.example.TaskManager.service;

import com.example.TaskManager.client.userClient;
import com.example.TaskManager.clientDTO.userResponse;
import com.example.TaskManager.dto.taskPatchRequestDTO;
import com.example.TaskManager.dto.taskPostRequestDTO;
import com.example.TaskManager.dto.taskSingleGetResponseDTO;
import com.example.TaskManager.model.Task;
import com.example.TaskManager.cache.userCacheService;
import com.example.TaskManager.repositry.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.math.BigInteger;
import java.util.List;

@Service
public class taskService {

    @Autowired
    private taskRepositry taskRepositry;

    @Autowired
    private userCacheService userCacheService;

    @Autowired
    private userClient userClient;

    public List<Task> getAllTask(){
        return taskRepositry.findByDeletedFalse();
    }

    public String addTask(taskPostRequestDTO taskDto){

        Task task = new Task();
        task.setTitle(taskDto.getTitle());
        task.setDescription(taskDto.getDescription());
        task.setCompleted(taskDto.isCompleted());
        taskRepositry.save(task);
        return "Task added Successfully";
    }

    public String deleteTask(Long id){
        Task task = taskRepositry.findById(id).orElseThrow(() -> new RuntimeException("Task Not Found"));
        task.setDeleted(true);
        taskRepositry.save(task);
        return "Task Deleted Successfully";
    }

    public taskSingleGetResponseDTO singleGetWithUser(Long id){
        Task task = taskRepositry.findById(id).orElseThrow(()-> new ResponseStatusException(HttpStatus.NOT_FOUND, "Task Not Found"));
        userResponse user = userCacheService.getUser(id);
        if (user == null) {
            user = userClient.getUserById(task.getUserId());
            userCacheService.saveUser(user.getUserId(),user);
        }

        taskSingleGetResponseDTO response = new taskSingleGetResponseDTO();
        response.setTitle(task.getTitle());
        response.setId(task.getId());
        response.setDescription(task.getDescription());
        response.setCompleted(task.getCompleted());
        response.setUserName(user.getUsername());
        response.setEmail(user.getEmail());
        return response;
    }

    public String taskPatch(Long id, taskPatchRequestDTO task){
        Task task1 = taskRepositry.findById(id).orElseThrow(()-> new RuntimeException("Task Not found"));
        if (task.getTitle()!=null) {
            task1.setTitle(task.getTitle());
        }
        if(task.getDescription()!=null) {
            task1.setDescription(task.getDescription());
        }
        if(task.getCompleted()!=null){
            task1.setCompleted(task.getCompleted());
        }
        if(task.getUserId()!=null){
            task1.setUserId(task.getUserId());
        }
        taskRepositry.save(task1);
        return "Task Patch Successfully";
    }
}
