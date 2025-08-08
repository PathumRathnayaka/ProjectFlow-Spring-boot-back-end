package com.project.ProjectFlow.dto;

import com.project.ProjectFlow.util.Role;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;


public class UserDto {
    private String id;

    private String name;
    private String email;
    private String avatar;

    @Enumerated(EnumType.STRING)
    private Role role;

    private String teamId;
    private String department;
    private boolean isActive;

    public UserDto() {
    }

    public UserDto(String id, String name, String email, String avatar, Role role, String teamId, String department, boolean isActive) {
        this.id = id;
        this.name = name;
        this.email = email;
        this.avatar = avatar;
        this.role = role;
        this.teamId = teamId;
        this.department = department;
        this.isActive = isActive;
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

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getAvatar() {
        return avatar;
    }

    public void setAvatar(String avatar) {
        this.avatar = avatar;
    }

    public Role getRole() {
        return role;
    }

    public void setRole(Role role) {
        this.role = role;
    }

    public String getTeamId() {
        return teamId;
    }

    public void setTeamId(String teamId) {
        this.teamId = teamId;
    }

    public String getDepartment() {
        return department;
    }

    public void setDepartment(String department) {
        this.department = department;
    }

    public boolean isActive() {
        return isActive;
    }

    public void setActive(boolean active) {
        isActive = active;
    }
}
