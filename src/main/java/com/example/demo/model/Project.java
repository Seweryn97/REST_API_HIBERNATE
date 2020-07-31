package com.example.demo.model;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import java.util.Set;

@Entity
@Table(name = "project")
public class Project {
    @Id
    @GeneratedValue
    private int id;
    @NotBlank
    private String description;
    @OneToMany(mappedBy = "project")
    private Set<TaskGroup> group;
    @OneToMany(mappedBy = "project")
    private Set<TaskGroup> projectSteps;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Set<TaskGroup> getGroup() {
        return group;
    }

    public void setGroup(Set<TaskGroup> group) {
        this.group = group;
    }
}
