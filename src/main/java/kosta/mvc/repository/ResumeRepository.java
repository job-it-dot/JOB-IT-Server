package kosta.mvc.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import kosta.mvc.domain.Resume;

public interface ResumeRepository extends JpaRepository<Resume, Long> {

}
