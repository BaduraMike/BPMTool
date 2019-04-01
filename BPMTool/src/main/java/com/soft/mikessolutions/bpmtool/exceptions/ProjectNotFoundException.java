package com.soft.mikessolutions.bpmtool.exceptions;

public class ProjectNotFoundException extends RuntimeException {
    public ProjectNotFoundException(Long id) {
        super("Project with {id} = " + id + " is not found");
    }
}
