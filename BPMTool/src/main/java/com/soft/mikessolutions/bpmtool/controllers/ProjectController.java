package com.soft.mikessolutions.bpmtool.controllers;

import com.soft.mikessolutions.bpmtool.entities.Project;
import com.soft.mikessolutions.bpmtool.services.ProjectService;
import com.soft.mikessolutions.bpmtool.services.ValidationErrorService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;


@RestController
@RequestMapping("/api/project")
public class ProjectController {
    private final ProjectService projectService;
    private final ValidationErrorService validationErrorService;

    ProjectController(ProjectService projectService, ValidationErrorService validationErrorService) {
        this.projectService = projectService;
        this.validationErrorService = validationErrorService;
    }

    @PostMapping("")
    public ResponseEntity<?> createNewProject(@Valid @RequestBody Project project, BindingResult result) {
        ResponseEntity<?> errorMap = validationErrorService.mapErrors(result);
        if (errorMap != null) {
            return errorMap;
        }
        Project newProject = projectService.save(project);
        return new ResponseEntity<>(project, HttpStatus.CREATED);
    }

    @GetMapping("/{projectIdentifier}")
    public ResponseEntity<?> getProjectByIdentifier(@PathVariable String projectIdentifier) {
        return new ResponseEntity<Project>(projectService.findByProjectIdentifier(projectIdentifier), HttpStatus.OK);
    }
}
