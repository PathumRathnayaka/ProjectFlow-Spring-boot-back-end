package com.project.ProjectFlow.service.imple;

import com.project.ProjectFlow.dao.TeamDao;
import com.project.ProjectFlow.model.Team;
import com.project.ProjectFlow.service.TeamService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

@Service
public class TeamServiceImpl implements TeamService {

    @Autowired
    TeamDao teamDao;

    @Override
    public ResponseEntity<Team> saveTeam(Team team) {
        Team save = teamDao.save(team);

        if (save==null){
            throw new  RuntimeException("Team Not save");
        }else {
            return ResponseEntity.ok(save);
        }
    }
}
