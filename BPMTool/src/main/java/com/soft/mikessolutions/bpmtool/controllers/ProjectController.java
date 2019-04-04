package com.soft.mikessolutions.bpmtool.controllers;

import com.soft.mikessolutions.bpmtool.entities.Project;
import com.soft.mikessolutions.bpmtool.services.ProjectService;
import com.soft.mikessolutions.bpmtool.services.ValidationErrorService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;


@RestController
@RequestMapping("/api/projects")
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

    @GetMapping("")
    public List<Project> findAllProjects() {
        return projectService.findAll();
    }

    @GetMapping("/{projectIdentifier}")
    public ResponseEntity<?> getProjectByIdentifier(@PathVariable String projectIdentifier) {
        return new ResponseEntity<Project>(projectService.findByProjectIdentifier(projectIdentifier), HttpStatus.OK);
    }

    @DeleteMapping("/{projectIdentifier}")
    public ResponseEntity<?> deleteProjectByIdentifier(@PathVariable String projectIdentifier) {
        projectService.deleteByProjectIdentifier(projectIdentifier);
        return new ResponseEntity<String>("Project with {IDENTIFIER} '" + projectIdentifier.toUpperCase() + "' is deleted.", HttpStatus.OK);
    }
}
