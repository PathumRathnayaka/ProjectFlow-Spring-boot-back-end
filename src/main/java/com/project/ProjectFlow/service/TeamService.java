package com.project.ProjectFlow.service;

import com.project.ProjectFlow.model.Team;
import org.springframework.http.ResponseEntity;

public interface TeamService {
    ResponseEntity<Team> saveTeam(Team team);
}
