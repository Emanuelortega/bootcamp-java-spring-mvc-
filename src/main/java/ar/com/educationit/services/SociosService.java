package ar.com.educationit.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import ar.com.educationit.domain.Socios;
import ar.com.educationit.repository.SociosRepository;

@Service
public class SociosService {
	
	//D.I
	@Autowired
	private SociosRepository repository;
	
	public List<Socios> buscarTodos(){
		return this.repository.findAll();
	}

	public void eliminar(Long idSocios) {
		this.repository.deleteById(idSocios);
		
	}

	public Socios buscarSocio(Long id) {
		Optional<Socios> socios = this.repository.findById(id);
		if(socios.isPresent()) {
			return socios.get();
		}else {
			return null;
		}
	}
}
