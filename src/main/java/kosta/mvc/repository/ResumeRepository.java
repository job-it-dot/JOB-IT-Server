package kosta.mvc.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import kosta.mvc.domain.Resume;

public interface ResumeRepository extends JpaRepository<Resume, Long> {

	public List<Resume> findByResumeStatus(int resumeStatus);

	public Resume findByResumeIdAndResumeStatus(Long resumeId, int resumeStatus);

}
