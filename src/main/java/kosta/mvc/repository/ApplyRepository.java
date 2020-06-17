package kosta.mvc.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import kosta.mvc.domain.Apply;

public interface ApplyRepository extends JpaRepository<Apply, Long> {

	@Query("SELECT * FROM apply WHERE recruit_id=?1")
	public List<Apply> findByRecruitId(Long recruitId);

	public Apply findByApplyId(Long applyId);

}
