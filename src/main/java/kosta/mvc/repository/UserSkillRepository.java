package kosta.mvc.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import kosta.mvc.domain.UserSkill;

public interface UserSkillRepository extends JpaRepository<UserSkill, Long> {

}
