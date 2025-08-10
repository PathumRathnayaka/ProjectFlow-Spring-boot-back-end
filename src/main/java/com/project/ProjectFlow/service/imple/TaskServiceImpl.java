package com.project.ProjectFlow.service.imple;

import com.project.ProjectFlow.customstatuscode.SuccessStatus;
import com.project.ProjectFlow.dao.TaskDao;
import com.project.ProjectFlow.dto.CustomStatus;
import com.project.ProjectFlow.dto.impl.TaskDto;
import com.project.ProjectFlow.entity.impl.TaskEntity;
import com.project.ProjectFlow.exception.ResourceNotFoundException;
import com.project.ProjectFlow.service.TaskService;
import com.project.ProjectFlow.util.Mapping;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
public class TaskServiceImpl implements TaskService {

    @Autowired
    private TaskDao taskDao;

    @Autowired
    private Mapping TaskMapping;

    @Override
    public CustomStatus save(TaskDto dto) {
        TaskEntity taskEntity = TaskMapping.toTaskEntity(dto);
        taskDao.save(taskEntity);
        return new SuccessStatus(HttpStatus.CREATED.value(), "Task saved successfully!");
    }

    @Override
    public CustomStatus delete(String id) {
        TaskEntity taskEntity = taskDao.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Task with ID " + id + " not found"));

        taskDao.delete(taskEntity);
        return new SuccessStatus(HttpStatus.OK.value(), "Task deleted successfully!");
    }

    @Override
    public CustomStatus update(String id, TaskDto dto) {
        TaskEntity taskEntity = taskDao.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Task with ID " + id + " not found"));

        taskEntity.setTitle(dto.getTitle());
        taskEntity.setDescription(dto.getDescription());
        taskEntity.setStatus(dto.getStatus());
        taskEntity.setPriority(dto.getPriority());
        taskEntity.setProjectId(dto.getProjectId());
        taskEntity.setAssigneeId(dto.getAssigneeId());
        taskEntity.setReporterId(dto.getReporterId());
        taskEntity.setDueDate(dto.getDueDate());
        taskEntity.setEstimatedHours(dto.getEstimatedHours());
        taskEntity.setActualHours(dto.getActualHours());
        taskEntity.setUpdatedAt(dto.getUpdatedAt());

        taskDao.save(taskEntity);
        return new SuccessStatus(HttpStatus.OK.value(), "Task updated successfully!");
    }

    @Override
    public TaskDto get(String id) {
        TaskEntity taskEntity = taskDao.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Task with ID " + id + " not found"));
        return TaskMapping.toTaskDto(taskEntity);
    }

    @Override
    public List<TaskDto> getAll() {
        return TaskMapping.asTaskDtoList(taskDao.findAll());
    }
}