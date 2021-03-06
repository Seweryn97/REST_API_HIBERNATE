package com.example.demo.adapter;

import com.example.demo.model.TaskGroup;
import com.example.demo.model.TaskGroupRepository;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
interface SqlTaskGroupRepository extends TaskGroupRepository, JpaRepository <TaskGroup, Integer> {

    @Override
    @Query("from TaskGroup g join fetch g.tasks ")
    List<TaskGroup> findAll();
}
