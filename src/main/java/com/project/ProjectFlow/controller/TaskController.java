package com.project.ProjectFlow.controller;

import com.project.ProjectFlow.customstatuscode.ErrorStatus;
import com.project.ProjectFlow.customstatuscode.SuccessStatus;
import com.project.ProjectFlow.dto.CustomStatus;
import com.project.ProjectFlow.dto.impl.TaskDto;
import com.project.ProjectFlow.service.imple.TaskServiceImpl;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/task")
@CrossOrigin(origins = "http://localhost:3000")
public class TaskController {

    @Autowired
    TaskServiceImpl taskService;

    @PostMapping
    public CustomStatus saveTask(@Valid @RequestBody TaskDto taskDto, BindingResult bindingResult) {
        if (bindingResult.hasErrors()) {
            // Collect first error message (you can customize to collect all)
            FieldError fieldError = bindingResult.getFieldErrors().get(0);
            String errorMessage = fieldError.getDefaultMessage();

            // Return validation error wrapped in ErrorStatus
            return new ErrorStatus(HttpStatus.BAD_REQUEST.value(), errorMessage);
        }

        // No errors, proceed normally
        return taskService.save(taskDto);
    }

    @PutMapping("/{id}")
    public CustomStatus updateTask(@Valid @RequestBody TaskDto taskDto, BindingResult bindingResult, @PathVariable String id) {
        if (bindingResult.hasErrors()) {
            // Collect first error message (you can customize to collect all)
            FieldError fieldError = bindingResult.getFieldErrors().get(0);
            String errorMessage = fieldError.getDefaultMessage();

            // Return validation error wrapped in ErrorStatus
            return new ErrorStatus(HttpStatus.BAD_REQUEST.value(), errorMessage);
        }
        return taskService.update(id, taskDto);
    }

    @DeleteMapping("/{id}")
    public CustomStatus deleteTask(@PathVariable("id") String id) {
        return taskService.delete(id);
    }

    @GetMapping
    public List<TaskDto> getAllTasks() {
        return taskService.getAll();
    }
}