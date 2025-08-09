package com.project.ProjectFlow.dao;

import com.project.ProjectFlow.entity.impl.TaskEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TaskDao extends JpaRepository<TaskEntity, String> {
}
