package com.project.ProjectFlow.dto.impl;

import com.project.ProjectFlow.dto.CustomStatus;

import java.util.List;

public class ProjectFolderDto implements CustomStatus {
    private String id;

    private String name;
    private String color;
    private List<String> projectIds;

    public ProjectFolderDto() {
    }

    public ProjectFolderDto(String id, String name, String color, List<String> projectIds) {
        this.id = id;
        this.name = name;
        this.color = color;
        this.projectIds = projectIds;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public List<String> getProjectIds() {
        return projectIds;
    }

    public void setProjectIds(List<String> projectIds) {
        this.projectIds = projectIds;
    }
}
