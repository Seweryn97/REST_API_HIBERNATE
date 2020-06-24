package com.example.demo.Controller;

import com.example.demo.TasksControl.TaskRepository;
import com.example.demo.model.Task;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.*;

import javax.transaction.Transactional;
import javax.validation.Valid;
import java.net.URI;
import java.util.List;
import java.util.Optional;


@Controller
public class TaskController {
    private final Logger logger = LoggerFactory.getLogger(TaskController.class);
    private final TaskRepository repository;

    TaskController(final TaskRepository repository){
        this.repository = repository;
    }

    @RequestMapping(method = RequestMethod.GET, path = "/tasks", params = {"!sort","!page","!size"})
    ResponseEntity<List<Task>> readAllTasks(){
        logger.warn("Exposed all tasks");
        return ResponseEntity.ok(repository.findAll());
    }

    @RequestMapping(method = RequestMethod.GET, path = "/tasks/{id}")
    ResponseEntity<?> readTaskById (@PathVariable int id){
        return ResponseEntity.ok(repository.findById(id).map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build()));
    }

    @RequestMapping(method = RequestMethod.POST, path = "/tasks")
    ResponseEntity<Task> createTask(@RequestBody @Valid Task entity){
        Task result =repository.save(entity);
        return ResponseEntity.created(URI.create("/"+result.getId())).body(result);
    }

    @RequestMapping(method = RequestMethod.PUT, path = "tasks/{id}")
    ResponseEntity<?> updateTasks(@PathVariable int id, @RequestBody @Valid Task entity){
        if(!repository.existsById(id)){
            logger.warn("Task no exists!");
            return ResponseEntity.notFound().build();
        }
        entity.setId(id);
        repository.save(entity);
        return ResponseEntity.noContent().build();
    }

    @Transactional
    @PatchMapping( "tasks/{id}")
    ResponseEntity<?> toggleTasks(@PathVariable int id){
        if(!repository.existsById(id)){
            logger.warn("Task no exists!");
            return ResponseEntity.notFound().build();
        }
        repository.findById(id).ifPresent(task -> task.setDone(!task.isDone()));
        return ResponseEntity.noContent().build();
    }

}
