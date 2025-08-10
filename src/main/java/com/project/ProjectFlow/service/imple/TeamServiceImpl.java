package com.project.ProjectFlow.service.imple;

import com.project.ProjectFlow.customstatuscode.ErrorStatus;
import com.project.ProjectFlow.customstatuscode.SuccessStatus;
import com.project.ProjectFlow.dao.TeamDao;
import com.project.ProjectFlow.dto.CustomStatus;
import com.project.ProjectFlow.dto.impl.TeamDto;
import com.project.ProjectFlow.entity.impl.TeamEntity;
import com.project.ProjectFlow.exception.ResourceNotFoundException;
import com.project.ProjectFlow.service.TeamService;
import com.project.ProjectFlow.util.Mapping;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

@Service
public class TeamServiceImpl implements TeamService {

    @Autowired
    private TeamDao teamDao;

    @Autowired
    private Mapping TeamMapping;

    @Override
    public CustomStatus save(TeamDto dto) {
        TeamEntity teamEntity = TeamMapping.toTeamEntity(dto);
        teamDao.save(teamEntity);
        return new SuccessStatus(HttpStatus.CREATED.value(), "Team saved successfully!");
    }

    @Override
    public CustomStatus delete(String id) {
        TeamEntity teamEntity = teamDao.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Team with ID " + id + " not found"));

        teamDao.delete(teamEntity);
        return new SuccessStatus(HttpStatus.OK.value(), "Team deleted successfully!");
    }

    @Override
    public CustomStatus update(String id, TeamDto dto) {
        TeamEntity teamEntity = teamDao.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Team with ID " + id + " not found"));

        teamEntity.setName(dto.getName());
        teamEntity.setDescription(dto.getDescription());
        teamEntity.setColor(dto.getColor());
        teamEntity.setMemberIds(dto.getMemberIds());
        teamEntity.setLeaderId(dto.getLeaderId());
        teamEntity.setCreatedAt(dto.getCreatedAt());

        teamDao.save(teamEntity);
        return new SuccessStatus(HttpStatus.OK.value(), "Team updated successfully!");
    }

    @Override
    public TeamDto get(String id) {
        TeamEntity teamEntity = teamDao.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Team with ID " + id + " not found"));
        return TeamMapping.toTeamDto(teamEntity);
    }

    @Override
    public List<TeamDto> getAll() {
        return TeamMapping.asTeamDtoList(teamDao.findAll());
    }
}