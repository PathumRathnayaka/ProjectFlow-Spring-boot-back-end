package com.project.ProjectFlow.entity;

import com.project.ProjectFlow.util.Priority;
import com.project.ProjectFlow.util.Status;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.Id;

import java.time.LocalDateTime;

public class Project {
    @Id
    private String id;

    private String name;
    private String description;

    @Enumerated(EnumType.STRING)
    private Status status;

    @Enumerated(EnumType.STRING)
    private Priority priority;

    private String startDate;
    private String dueDate;

    private int progress;
    private String teamId;
    private String ownerId;
    private String folderId;

    private LocalDateTime createdAt;
    private LocalDateTime updatedAt;
}
