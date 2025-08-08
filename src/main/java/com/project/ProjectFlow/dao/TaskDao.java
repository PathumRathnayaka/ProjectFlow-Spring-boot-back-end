package com.project.ProjectFlow.dao;

import com.project.ProjectFlow.entity.impl.TaskEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TaskDao extends JpaRepository<TaskEntity, String> {
}
