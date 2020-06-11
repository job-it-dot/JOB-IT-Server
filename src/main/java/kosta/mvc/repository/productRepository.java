package kosta.mvc.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import kosta.mvc.domain.Product;

public interface productRepository extends JpaRepository<Product, Long> {

}
