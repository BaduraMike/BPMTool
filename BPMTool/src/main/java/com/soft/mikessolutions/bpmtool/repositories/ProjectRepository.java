package com.soft.mikessolutions.bpmtool.repositories;

import com.soft.mikessolutions.bpmtool.entities.Project;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface ProjectRepository extends JpaRepository<Project, Long> {
    Optional<Project> findByProjectIdentifier(String projectIdentifier);
}
