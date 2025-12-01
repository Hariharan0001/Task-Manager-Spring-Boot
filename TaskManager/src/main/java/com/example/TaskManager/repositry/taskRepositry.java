package com.example.TaskManager.repositry;

import com.example.TaskManager.dto.taskSingleGetResponseDTO;
import com.example.TaskManager.model.Task;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.math.BigInteger;
import java.util.List;


@Repository
public interface taskRepositry extends JpaRepository<Task, Long> {
    List<Task> findByDeletedFalse();

    @Query(value = """
            select t.id,t.title,t.description,t.completed,u.username,u.email from tasks t
            left join users u on t.user_id = u.user_id
            where t.deleted is not true and t.id =:id
            """, nativeQuery = true)
    taskSingleGetResponseDTO findTaskWithUserDetails(@Param("id") Long id);
}
