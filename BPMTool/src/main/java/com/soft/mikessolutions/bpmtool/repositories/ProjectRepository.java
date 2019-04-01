package com.soft.mikessolutions.bpmtool.repositories;

import com.soft.mikessolutions.bpmtool.entities.Project;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ProjectRepository extends JpaRepository<Project, Long> {
}
