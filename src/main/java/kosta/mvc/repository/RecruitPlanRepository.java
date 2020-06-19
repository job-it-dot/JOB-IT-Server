package kosta.mvc.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import kosta.mvc.domain.RecruitPlan;

public interface RecruitPlanRepository extends JpaRepository<RecruitPlan, Long> {

	@Query(value = "SELECT * FROM recruit_plan rp WHERE rp.company_id=?1", nativeQuery = true)
	public List<RecruitPlan> findByCompanyId(Long companyId);

	public RecruitPlan findByRecruitPlanId(Long recruitPlanId);



}
