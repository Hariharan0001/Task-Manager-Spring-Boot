package com.example.user.service;

import com.example.user.DTO.userPatchRequestDTO;
import com.example.user.DTO.userResponseDTO;
import com.example.user.model.User;
import com.example.user.repositry.userRepositry;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import com.example.user.events.UserEventProducer;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.server.ResponseStatusException;

@Service
public class userService {

    @Autowired
    private userRepositry userRepositry;

    @Autowired
    private UserEventProducer userEventProducer;

    public userResponseDTO getUserById(Long id){
        User user =  userRepositry.findById(id).orElseThrow(()-> new ResponseStatusException(HttpStatus.NOT_FOUND, "User Not Found"));
        userResponseDTO userResponse = new userResponseDTO();
        userResponse.setUserId(user.getUserId());
        userResponse.setUsername(user.getUsername());
        userResponse.setEmail(user.getEmail());
        return userResponse;
    }


    @Transactional
    public String userPatch(Long id, userPatchRequestDTO user){
        User user1 = userRepositry.findById(id).orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "User Not Found"));
        if(user.getUserName()!=null) {
            user1.setUsername(user.getUserName());
        }
        if(user.getEmail()!=null) {
            user1.setEmail(user.getEmail());
        }
        User savedUser = userRepositry.save(user1);
        userEventProducer.publishUserUpdatedEvent(
                new userResponseDTO(
                        savedUser.getUserId(),
                        savedUser.getUsername(),
                        savedUser.getEmail()
                )
        );
        return "User Update Successfully";
    }
}
