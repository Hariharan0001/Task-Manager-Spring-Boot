package com.example.user.repositry;

import com.example.user.model.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface userRepositry extends JpaRepository<User, Long> {
}
