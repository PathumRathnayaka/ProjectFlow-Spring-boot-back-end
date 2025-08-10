package com.project.ProjectFlow.service.imple;

import com.project.ProjectFlow.customstatuscode.ErrorStatus;
import com.project.ProjectFlow.customstatuscode.SuccessStatus;
import com.project.ProjectFlow.dao.ProjectDao;
import com.project.ProjectFlow.dto.CustomStatus;
import com.project.ProjectFlow.dto.impl.ProjectDto;
import com.project.ProjectFlow.entity.impl.ProjectEntity;
import com.project.ProjectFlow.exception.ResourceNotFoundException;
import com.project.ProjectFlow.service.ProjectService;
import com.project.ProjectFlow.util.Mapping;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

@Service
public class ProjectServiceImpl implements ProjectService {

    @Autowired
    private ProjectDao projectDao;

    @Autowired
    private Mapping ProjectMapping;

    @Override
    public CustomStatus save(ProjectDto dto) {
        ProjectEntity projectEntity = ProjectMapping.toProjectEntity(dto);
        projectDao.save(projectEntity);
        return new SuccessStatus(HttpStatus.CREATED.value(), "Project saved successfully!");
    }

    @Override
    public CustomStatus delete(String id) {
        ProjectEntity projectEntity = projectDao.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Project with ID " + id + " not found"));

        projectDao.delete(projectEntity);
        return new SuccessStatus(HttpStatus.OK.value(), "Project deleted successfully!");
    }

    @Override
    public CustomStatus update(String id, ProjectDto dto) {
        ProjectEntity projectEntity = projectDao.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Project with ID " + id + " not found"));

        projectEntity.setName(dto.getName());
        projectEntity.setDescription(dto.getDescription());
        projectEntity.setStatus(dto.getStatus());
        projectEntity.setPriority(dto.getPriority());
        projectEntity.setStartDate(dto.getStartDate());
        projectEntity.setDueDate(dto.getDueDate());
        projectEntity.setProgress(dto.getProgress());
        projectEntity.setTeamId(dto.getTeamId());
        projectEntity.setOwnerId(dto.getOwnerId());
        projectEntity.setFolderId(dto.getFolderId());
        projectEntity.setCreatedAt(dto.getCreatedAt());
        projectEntity.setUpdatedAt(dto.getUpdatedAt());

        projectDao.save(projectEntity);
        return new SuccessStatus(HttpStatus.OK.value(), "Project updated successfully!");
    }

    @Override
    public ProjectDto get(String id) {
        ProjectEntity projectEntity = projectDao.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Project with ID " + id + " not found"));
        return ProjectMapping.toProjectDto(projectEntity);
    }

    @Override
    public List<ProjectDto> getAll() {
        return ProjectMapping.asProjectDtoList(projectDao.findAll());
    }
}