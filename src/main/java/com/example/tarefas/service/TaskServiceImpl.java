package com.example.tarefas.service;

import com.example.tarefas.model.Task;
import java.util.List;
import com.example.tarefas.repository.TaskRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class TaskServiceImpl implements TaskService {

    @Autowired
    private TaskRepository taskRepository;

    @Override
    public List<Task> findAll() {
        return taskRepository.findAll();
    }

    @Override
    public Task save(Task task) {
        if (task.getDisplayOrder() == null) {
            Integer maxOrder = taskRepository.findMaxDisplayOrder();
            task.setDisplayOrder((maxOrder != null ? maxOrder : 0) + 1);
        }
        return taskRepository.save(task);
    }


    @Override
    public boolean deleteById(Long id) {
        if (taskRepository.existsById(id)) {
            taskRepository.deleteById(id);
            return true;
        } else {
            return false;
        }
    }

    @Override
    public Task updateTask(Long id, Task taskDetails) {
        Task task = taskRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Task not found"));
        task.setName(taskDetails.getName());
        task.setCost(taskDetails.getCost());
        task.setDueDate(taskDetails.getDueDate());
        return taskRepository.save(task);
    }

    public List<Task> updateTaskOrder(List<Task> tasks) {
        for (int i = 0; i < tasks.size(); i++) {
            Task task = tasks.get(i);
            task.setDisplayOrder(i + 1);
            taskRepository.save(task);
        }
        return tasks;
    }


}
