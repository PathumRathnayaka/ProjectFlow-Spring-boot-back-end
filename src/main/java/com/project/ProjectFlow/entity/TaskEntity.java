package com.project.ProjectFlow.entity;

import com.project.ProjectFlow.util.Priority;
import com.project.ProjectFlow.util.Status;
import jakarta.persistence.ElementCollection;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.Id;

import java.time.LocalDateTime;
import java.util.List;

public class TaskEntity {
    @Id
    private String id;

    private String title;
    private String description;

    @Enumerated(EnumType.STRING)
    private Status status;

    @Enumerated(EnumType.STRING)
    private Priority priority;

    private String projectId;
    private String assigneeId;
    private String reporterId;

    private String dueDate;
    private double estimatedHours;
    private double actualHours;

    @ElementCollection
    private List<String> tags;

    private LocalDateTime createdAt;
    private LocalDateTime updatedAt;
}
