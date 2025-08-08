package com.project.ProjectFlow.entity;

import jakarta.persistence.ElementCollection;
import jakarta.persistence.Id;

import java.time.LocalDateTime;
import java.util.List;

public class TeamEntity {
    @Id
    private String id;

    private String name;
    private String description;
    private String color;

    @ElementCollection
    private List<String> memberIds;

    private String leaderId;
    private LocalDateTime createdAt;
}
