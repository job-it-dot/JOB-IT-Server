package kosta.mvc.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import kosta.mvc.domain.Project;

public interface ProjectRepository extends JpaRepository<Project, Long> {

}
