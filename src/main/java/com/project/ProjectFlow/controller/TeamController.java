package com.project.ProjectFlow.controller;

import com.project.ProjectFlow.customstatuscode.ErrorStatus;
import com.project.ProjectFlow.customstatuscode.SuccessStatus;
import com.project.ProjectFlow.dto.CustomStatus;
import com.project.ProjectFlow.dto.impl.TeamDto;
import com.project.ProjectFlow.service.imple.TeamServiceImpl;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/team")
@CrossOrigin(origins = "http://localhost:3000")
public class TeamController {

    @Autowired
    TeamServiceImpl teamService;

    @PostMapping
    public CustomStatus saveTeam(@Valid @RequestBody TeamDto teamDto, BindingResult bindingResult) {
        if (bindingResult.hasErrors()) {
            // Collect first error message (you can customize to collect all)
            FieldError fieldError = bindingResult.getFieldErrors().get(0);
            String errorMessage = fieldError.getDefaultMessage();

            // Return validation error wrapped in ErrorStatus
            return new ErrorStatus(HttpStatus.BAD_REQUEST.value(), errorMessage);
        }

        // No errors, proceed normally
        return teamService.save(teamDto);
    }

    @PutMapping("/{id}")
    public CustomStatus updateTeam(@Valid @RequestBody TeamDto teamDto, BindingResult bindingResult, @PathVariable String id) {
        if (bindingResult.hasErrors()) {
            // Collect first error message (you can customize to collect all)
            FieldError fieldError = bindingResult.getFieldErrors().get(0);
            String errorMessage = fieldError.getDefaultMessage();

            // Return validation error wrapped in ErrorStatus
            return new ErrorStatus(HttpStatus.BAD_REQUEST.value(), errorMessage);
        }
        return teamService.update(id, teamDto);
    }

    @DeleteMapping("/{id}")
    public CustomStatus deleteTeam(@PathVariable("id") String id) {
        return teamService.delete(id);
    }

    @GetMapping
    public List<TeamDto> getAllTeams() {
        return teamService.getAll();
    }
}