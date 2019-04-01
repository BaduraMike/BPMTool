package com.soft.mikessolutions.bpmtool.services.implementations;

import com.soft.mikessolutions.bpmtool.entities.Project;
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
                .orElseThrow(() -> new ProjectNotFoundException(id));
    }

    @Override
    public Project save(Project project) {
        return projectRepository.save(project);
    }

    @Override
    public void delete(Project project) {
        projectRepository.delete(project);
    }

    @Override
    public void deleteById(Long id) {
        projectRepository.deleteById(id);
    }
}
