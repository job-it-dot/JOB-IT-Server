package kosta.mvc.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import kosta.mvc.domain.LangLicense;

public interface LangLicenseRepository extends JpaRepository<LangLicense, Long> {

}
