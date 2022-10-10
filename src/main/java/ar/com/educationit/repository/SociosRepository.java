package ar.com.educationit.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import ar.com.educationit.domain.Socios;

@Repository

/*
 * T es la entidad sobre la cual voy a trabajar(entity)
 * ID: es el tipo de datos de la id del Entity
 * */
public interface SociosRepository extends JpaRepository<Socios, Long>{ //ex DAO

	
	
	
	
}
