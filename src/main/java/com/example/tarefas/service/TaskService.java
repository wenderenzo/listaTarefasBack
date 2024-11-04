package com.example.tarefas.service;


import com.example.tarefas.model.Task;
import java.util.List;

public interface TaskService {
    List<Task> findAll();
    Task save(Task task);
    boolean deleteById(Long id);
    Task updateTask(Long id, Task taskDetails);

    List<Task> updateTaskOrder(List<Task> tasks);

}
