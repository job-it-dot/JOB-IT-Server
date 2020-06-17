package kosta.mvc.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import kosta.mvc.domain.RequiredSkill;

public interface RequiredSkillRepository extends JpaRepository<RequiredSkill, Long> {

}
