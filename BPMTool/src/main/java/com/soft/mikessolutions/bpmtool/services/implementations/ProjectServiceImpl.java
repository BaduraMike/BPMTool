package com.soft.mikessolutions.bpmtool.services.implementations;

import com.soft.mikessolutions.bpmtool.entities.Project;
import com.soft.mikessolutions.bpmtool.exceptions.ProjectIdException;
import com.soft.mikessolutions.bpmtool.exceptions.ProjectNotFoundException;
import com.soft.mikessolutions.bpmtool.repositories.ProjectRepository;
import com.soft.mikessolutions.bpmtool.services.ProjectService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProjectServiceImpl implements ProjectService {
    private final ProjectRepository projectRepository;

    ProjectServiceImpl(ProjectRepository projectRepository) {
        this.projectRepository = projectRepository;
    }

    @Override
    public List<Project> findAll() {
        return projectRepository.findAll();
    }

    @Override
    public Project findById(Long id) {
        return projectRepository.findById(id)
                .orElseThrow(() -> new ProjectNotFoundException("Project with ID '" + id + "' is not found."));
    }

    @Override
    public Project save(Project project) {
        try {
            project.setProjectIdentifier(project.getProjectIdentifier().toUpperCase());
            return projectRepository.save(project);
        } catch (Exception ex) {
            throw new ProjectIdException("Project ID '" + project.getProjectIdentifier().toUpperCase() + "' already exists.");
        }
    }

    @Override
    public void delete(Project project) {
        projectRepository.delete(project);
    }

    @Override
    public void deleteById(Long id) {
        projectRepository.deleteById(id);
    }

    @Override
    public Project findByProjectIdentifier(String projectIdentifier) {
        return projectRepository.findByProjectIdentifier(projectIdentifier.toUpperCase())
                .orElseThrow(() -> new ProjectNotFoundException("Project with IDENTIFIER '" + projectIdentifier.toUpperCase() + "' is not found."));
    }
}
