package kosta.mvc.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import kosta.mvc.domain.LangClass;

public interface LangClassRepository extends JpaRepository<LangClass, Long> {

}
