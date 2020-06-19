package kosta.mvc.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import kosta.mvc.domain.Recruit;

public interface RecruitRepository extends JpaRepository<Recruit, Long>, RecruitRepositoryCustom {

	@Query(value = "SELECT * FROM recruit r WHERE r.company_id=?1", nativeQuery = true)
	public List<Recruit> findByCompanyId(Long companyId);

	public Recruit findByRecruitId(Long recruitId);

}
