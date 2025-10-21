package com.project.ProjectFlow.controller;

import com.project.ProjectFlow.customstatuscode.ErrorStatus;
import com.project.ProjectFlow.customstatuscode.SuccessStatus;
import com.project.ProjectFlow.dto.CustomStatus;
import com.project.ProjectFlow.dto.impl.ProjectDto;
import com.project.ProjectFlow.service.imple.ProjectServiceImpl;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/project")
@CrossOrigin(origins = "http://localhost:3000")
public class ProjectController {

    @Autowired
    ProjectServiceImpl projectService;

    @PostMapping
    public CustomStatus saveProject(@Valid @RequestBody ProjectDto projectDto, BindingResult bindingResult) {
        if (bindingResult.hasErrors()) {
            // Collect first error message (you can customize to collect all)
            FieldError fieldError = bindingResult.getFieldErrors().get(0);
            String errorMessage = fieldError.getDefaultMessage();

            // Return validation error wrapped in ErrorStatus
            return new ErrorStatus(HttpStatus.BAD_REQUEST.value(), errorMessage);
        }

        // No errors, proceed normally
        return projectService.save(projectDto);
    }

    @PutMapping("/{id}")
    public CustomStatus updateProject(@Valid @RequestBody ProjectDto projectDto, BindingResult bindingResult, @PathVariable String id) {
        if (bindingResult.hasErrors()) {
            // Collect first error message (you can customize to collect all)
            FieldError fieldError = bindingResult.getFieldErrors().get(0);
            String errorMessage = fieldError.getDefaultMessage();

            // Return validation error wrapped in ErrorStatus
            return new ErrorStatus(HttpStatus.BAD_REQUEST.value(), errorMessage);
        }
        return projectService.update(id, projectDto);
    }

    @DeleteMapping("/{id}")
    public CustomStatus deleteProject(@PathVariable("id") String id) {
        return projectService.delete(id);
    }

    @GetMapping
    public List<ProjectDto> getAllProjects() {
        return projectService.getAll();
    }
}