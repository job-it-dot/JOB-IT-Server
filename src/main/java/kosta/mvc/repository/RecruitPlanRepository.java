package kosta.mvc.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import kosta.mvc.domain.RecruitPlan;

public interface RecruitPlanRepository extends JpaRepository<RecruitPlan, Long> {

	/*@Query("SELECT * FROM recruit_plan WHERE company_id=?1")
	public List<RecruitPlan> findByCompanyId(Long companyId);

	public RecruitPlan findByRecruitPlanId(Long recruitPlanId);*/

}
