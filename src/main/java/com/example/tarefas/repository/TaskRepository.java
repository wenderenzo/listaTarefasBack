package com.example.tarefas.repository;

import com.example.tarefas.model.Task;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface TaskRepository extends JpaRepository<Task, Long> {
    Optional<Task> findByName(String name);

    @Query("SELECT COALESCE(MAX(t.displayOrder), 0) FROM Task t")
    Integer findMaxDisplayOrder();
}
