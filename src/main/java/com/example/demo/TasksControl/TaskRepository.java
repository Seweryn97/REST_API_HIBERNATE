package com.example.demo.TasksControl;

import com.example.demo.model.Task;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface TaskRepository  {
    List<Task> findAll();

    Optional <Task> findById(Integer id);

    boolean existsById(Integer id);

    Task save(Task Entity);
}
