package com.example.TaskManager.repositry;

import com.example.TaskManager.model.User;
import org.springframework.data.jpa.repository.JpaRepository;


public interface userRepositry extends JpaRepository<User, Long> {
}
