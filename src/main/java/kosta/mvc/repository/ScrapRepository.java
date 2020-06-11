package kosta.mvc.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import kosta.mvc.domain.Scrap;

public interface ScrapRepository extends JpaRepository<Scrap, Long> {

}
