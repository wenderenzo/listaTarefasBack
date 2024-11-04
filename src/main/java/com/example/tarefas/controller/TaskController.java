package com.example.tarefas.controller;

import com.example.tarefas.model.Task;
import com.example.tarefas.service.TaskService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

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
    public ResponseEntity<Map<String, String>> deleteTask(@PathVariable Long id) {
        Map<String, String> response = new HashMap<>();
        if (taskService.deleteById(id)) {
            response.put("message", "Task deleted successfully");
            return ResponseEntity.ok(response);
        } else {
            response.put("message", "Task not found");
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(response);
        }
    }

    @PutMapping("/order")
    public List<Task> updateTaskOrder(@RequestBody List<Task> tasks) {
        return taskService.updateTaskOrder(tasks);
    }

}
