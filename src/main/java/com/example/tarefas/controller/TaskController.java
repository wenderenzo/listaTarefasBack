package com.example.tarefas.controller;

import com.example.tarefas.model.Task;
import com.example.tarefas.service.TaskService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/tasks")
public class TaskController {

    @Autowired
    private TaskService taskService;

    @GetMapping
    public List<Task> getAllTasks() {
        return taskService.findAll();
    }

    @PostMapping
    public Task createTask(@RequestBody Task task) {
        return taskService.save(task);
    }

    @PutMapping("/{id}")
    public Task updateTask(@PathVariable Long id, @RequestBody Task task) {
        return taskService.updateTask(id, task);
    }

    @DeleteMapping("/{id}")
    public String deleteTask(@PathVariable Long id) {
        return taskService.deleteById(id);
    }

    @PutMapping("/order")
    public List<Task> updateTaskOrder(@RequestBody List<Task> tasks) {
        return taskService.updateTaskOrder(tasks);
    }

}
