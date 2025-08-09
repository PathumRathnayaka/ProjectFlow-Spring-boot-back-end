package com.project.ProjectFlow.dao;

import com.project.ProjectFlow.entity.impl.ProjectFolderEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ProjectFolderDao extends JpaRepository<ProjectFolderEntity, String> {
}
