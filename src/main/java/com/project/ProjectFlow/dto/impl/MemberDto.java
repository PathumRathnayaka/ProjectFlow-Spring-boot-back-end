package com.project.ProjectFlow.dto.impl;

import com.project.ProjectFlow.dto.CustomStatus;
import com.project.ProjectFlow.util.Role;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Pattern;

import java.time.LocalDateTime;


public class MemberDto implements CustomStatus {
    private String id;

    @NotBlank(message = "Name is required")
    @Pattern(regexp = "^[A-Za-z ]+$", message = "Name must contain only letters and spaces")
    private String name;
    @NotBlank(message = "Email is required")
    @Email(message = "Email should be valid")
    @Pattern(regexp = "^[A-Za-z0-9._%+-]+@gmail\\.com$", message = "Email must be a Gmail address")
    private String email;
    private String avatar;


    private Role role;

    private String teamId;
    private String department;
    private boolean isActive;
    private LocalDateTime joinedAt;

    public MemberDto() {
    }

    public MemberDto(String id, String name, String email, String avatar, Role role, String teamId, String department, boolean isActive, LocalDateTime joinedAt) {
        this.id = id;
        this.name = name;
        this.email = email;
        this.avatar = avatar;
        this.role = role;
        this.teamId = teamId;
        this.department = department;
        this.isActive = isActive;
        this.joinedAt = joinedAt;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public @NotBlank(message = "Name is required") @Pattern(regexp = "^[A-Za-z ]+$", message = "Name must contain only letters and spaces") String getName() {
        return name;
    }

    public void setName(@NotBlank(message = "Name is required") @Pattern(regexp = "^[A-Za-z ]+$", message = "Name must contain only letters and spaces") String name) {
        this.name = name;
    }

    public @NotBlank(message = "Email is required") @Email(message = "Email should be valid") @Pattern(regexp = "^[A-Za-z0-9._%+-]+@gmail\\.com$", message = "Email must be a Gmail address") String getEmail() {
        return email;
    }

    public void setEmail(@NotBlank(message = "Email is required") @Email(message = "Email should be valid") @Pattern(regexp = "^[A-Za-z0-9._%+-]+@gmail\\.com$", message = "Email must be a Gmail address") String email) {
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

    public LocalDateTime getJoinedAt() {
        return joinedAt;
    }

    public void setJoinedAt(LocalDateTime joinedAt) {
        this.joinedAt = joinedAt;
    }
}
