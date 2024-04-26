package com.daniilkuz.Exercise18;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TaskService {
    private final TaskRepository taskRepository;

    @Autowired
    public TaskService(TaskRepository taskRepository) {
        this.taskRepository = taskRepository;
    }

    public List<task> getAllTasks() {
        return taskRepository.findAll();
    }

    public task getTaskById(Long id) {
        return taskRepository.findById(id).orElse(null);
    }

    public task saveTask(task task) {
        return taskRepository.save(task);
    }

    public task updateTask(Long id, task task) {
        if (taskRepository.existsById(id)) {
            task.setId(id);
            return taskRepository.save(task);
        } else {
            return null; // or throw exception
        }
    }

    public void deleteTask(Long id) {
        taskRepository.deleteById(id);
    }
}
