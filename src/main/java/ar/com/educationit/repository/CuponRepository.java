package ar.com.educationit.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import ar.com.educationit.domain.Cupon;

@Repository
public interface CuponRepository extends JpaRepository<Cupon, Long> {

}
