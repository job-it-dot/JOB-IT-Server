package kosta.mvc.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import kosta.mvc.domain.Recruit;

public interface RecruitRepository extends JpaRepository<Recruit, Long> {

}
