package kosta.mvc.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import kosta.mvc.domain.RecruitPlan;

public interface RecruitPlanRepository extends JpaRepository<RecruitPlan, Long> {

}
