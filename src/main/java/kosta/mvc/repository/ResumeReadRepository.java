package kosta.mvc.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import kosta.mvc.domain.ResumeRead;

public interface ResumeReadRepository extends JpaRepository<ResumeRead, Long> {

}
