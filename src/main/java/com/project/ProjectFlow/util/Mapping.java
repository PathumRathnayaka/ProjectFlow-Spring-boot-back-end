package com.project.ProjectFlow.util;

import com.project.ProjectFlow.dto.impl.*;
import com.project.ProjectFlow.entity.impl.*;
import org.modelmapper.ModelMapper;
import org.modelmapper.TypeToken;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class Mapping {

    @Autowired
    private ModelMapper modelMapper;


    // for Member Mapping
    public MemberEntity toMemberEntity (MemberDto memberDto){
        return modelMapper.map(memberDto, MemberEntity.class);
    }
    public MemberDto toMemberDto (MemberEntity memberEntity){
        return modelMapper.map(memberEntity, MemberDto.class);
    }
    public List<MemberDto> asMemberDtoList(List<MemberEntity> memberEntityList){return modelMapper.map(memberEntityList, new TypeToken<List<MemberDto>>(){}.getType());}

    // for Member Mapping
    public TeamEntity toTeamEntity (TeamDto teamDto){
        return modelMapper.map(teamDto, TeamEntity.class);
    }
    public TeamDto toTeamDto (TeamEntity teamEntity){
        return modelMapper.map(teamEntity, TeamDto.class);
    }
    public List<TeamDto> asTeamDtoList(List<TeamEntity> teamEntityList){return modelMapper.map(teamEntityList, new TypeToken<List<TeamDto>>(){}.getType());}

    // for Project Mapping
    public ProjectEntity toProjectEntity(ProjectDto projectDto) {
        return modelMapper.map(projectDto, ProjectEntity.class);
    }

    public ProjectDto toProjectDto(ProjectEntity projectEntity) {
        return modelMapper.map(projectEntity, ProjectDto.class);
    }

    public List<ProjectDto> asProjectDtoList(List<ProjectEntity> projectEntityList) {
        return modelMapper.map(projectEntityList, new TypeToken<List<ProjectDto>>() {}.getType());
    }

    // for ProjectFolder Mapping
    public ProjectFolderEntity toProjectFolderEntity(ProjectFolderDto projectFolderDto) {
        return modelMapper.map(projectFolderDto, ProjectFolderEntity.class);
    }

    public ProjectFolderDto toProjectFolderDto(ProjectFolderEntity projectFolderEntity) {
        return modelMapper.map(projectFolderEntity, ProjectFolderDto.class);
    }

    public List<ProjectFolderDto> asProjectFolderDtoList(List<ProjectFolderEntity> projectFolderEntityList) {
        return modelMapper.map(projectFolderEntityList, new TypeToken<List<ProjectFolderDto>>() {}.getType());
    }

    // for Task Mapping
    public TaskEntity toTaskEntity(TaskDto taskDto) {
        return modelMapper.map(taskDto, TaskEntity.class);
    }

    public TaskDto toTaskDto(TaskEntity taskEntity) {
        return modelMapper.map(taskEntity, TaskDto.class);
    }

    public List<TaskDto> asTaskDtoList(List<TaskEntity> taskEntityList) {
        return modelMapper.map(taskEntityList, new TypeToken<List<TaskDto>>() {}.getType());
    }
}
