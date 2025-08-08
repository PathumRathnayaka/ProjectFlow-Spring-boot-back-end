package com.project.ProjectFlow.entity;

import jakarta.persistence.ElementCollection;
import jakarta.persistence.Id;

import java.util.List;

public class ProjectFolderEntity {
    @Id
    private String id;

    private String name;
    private String color;

    @ElementCollection
    private List<String> projectIds;

}
