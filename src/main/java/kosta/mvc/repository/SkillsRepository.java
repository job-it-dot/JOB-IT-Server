package kosta.mvc.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import kosta.mvc.domain.Skills;

public interface SkillsRepository extends JpaRepository<Skills, Long> {

}
