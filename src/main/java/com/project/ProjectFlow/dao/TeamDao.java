package com.project.ProjectFlow.dao;

import com.project.ProjectFlow.model.Team;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TeamDao extends JpaRepository<Team,String> {
}
