package com.example.demo.model;


import java.util.List;
import java.util.Optional;

public interface TaskGroupRepository {

    List<TaskGroup> findAll();

    Optional<TaskGroup> finfById(Integer id);

    TaskGroup save(TaskGroup entity);
}
