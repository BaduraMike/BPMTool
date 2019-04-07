package com.soft.mikessolutions.bpmtool.services;

import com.soft.mikessolutions.bpmtool.entities.Project;
import org.springframework.stereotype.Service;

@Service
public interface ProjectService extends CrudService<Project, Long> {
    Project findByProjectIdentifier(String projectIdentifier);

    void deleteByProjectIdentifier(String projectIdentifier);
}