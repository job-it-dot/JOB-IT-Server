package kosta.mvc.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import kosta.mvc.domain.LangLevel;

public interface LangLevelRepository extends JpaRepository<LangLevel, Long> {

}
