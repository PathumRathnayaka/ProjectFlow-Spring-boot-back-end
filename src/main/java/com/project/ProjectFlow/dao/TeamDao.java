package com.project.ProjectFlow.dao;

import com.project.ProjectFlow.entity.impl.TeamEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TeamDao extends JpaRepository<TeamEntity,String> {
}
