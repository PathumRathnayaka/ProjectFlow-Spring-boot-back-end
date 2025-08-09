package com.project.ProjectFlow.dao;

import com.project.ProjectFlow.entity.impl.ProjectEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ProjectDao extends JpaRepository<ProjectEntity, String> {
}
