package kosta.mvc.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import kosta.mvc.domain.Apply;

public interface ApplyRepository extends JpaRepository<Apply, Long> {

	public Apply findByApplyId(Long applyId);

}
