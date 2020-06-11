package kosta.mvc.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import kosta.mvc.domain.RequiredSkills;

public interface RequiredSkillsRepository extends JpaRepository<RequiredSkills, Long> {

}
