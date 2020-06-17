package kosta.mvc.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import kosta.mvc.domain.Perchase;

public interface PerchaseRepository extends JpaRepository<Perchase, Long> {

	public Perchase findByPerchaseId(Long perchaseId);

}
