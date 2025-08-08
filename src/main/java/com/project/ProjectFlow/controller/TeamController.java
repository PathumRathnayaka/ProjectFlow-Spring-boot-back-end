package com.project.ProjectFlow.controller;

import com.project.ProjectFlow.model.Team;
import com.project.ProjectFlow.service.TeamService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/team")
public class TeamController {

    @Autowired
    TeamService teamService;

    @PostMapping
    public ResponseEntity<Team> saveTeam(@RequestBody Team team){
        return teamService.saveTeam(team);
    }

}
