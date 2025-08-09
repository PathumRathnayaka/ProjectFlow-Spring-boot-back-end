package com.project.ProjectFlow.dto.impl;

import com.project.ProjectFlow.dto.CustomStatus;
import jakarta.persistence.ElementCollection;

import java.time.LocalDateTime;
import java.util.List;

public class TeamDto implements CustomStatus {
    private String id;

    private String name;
    private String description;
    private String color;

    @ElementCollection
    private List<String> memberIds;

    private String leaderId;
    private LocalDateTime createdAt;

    public TeamDto() {
    }

    public TeamDto(String id, String name, String description, String color, List<String> memberIds, String leaderId, LocalDateTime createdAt) {
        this.id = id;
        this.name = name;
        this.description = description;
        this.color = color;
        this.memberIds = memberIds;
        this.leaderId = leaderId;
        this.createdAt = createdAt;
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

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public List<String> getMemberIds() {
        return memberIds;
    }

    public void setMemberIds(List<String> memberIds) {
        this.memberIds = memberIds;
    }

    public String getLeaderId() {
        return leaderId;
    }

    public void setLeaderId(String leaderId) {
        this.leaderId = leaderId;
    }

    public LocalDateTime getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(LocalDateTime createdAt) {
        this.createdAt = createdAt;
    }
}
