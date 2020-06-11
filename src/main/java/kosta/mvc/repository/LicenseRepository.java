package kosta.mvc.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import kosta.mvc.domain.License;

public interface LicenseRepository extends JpaRepository<License, Long> {

}
