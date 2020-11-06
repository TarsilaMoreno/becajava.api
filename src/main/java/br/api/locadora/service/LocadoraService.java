package br.api.locadora.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.api.locadora.model.Locadora;
import br.api.locadora.repository.LocadoraRepository;

@Service
public class LocadoraService {

	final LocadoraRepository _repository;

	@Autowired
	public LocadoraService(LocadoraRepository repository) {
		_repository = repository;
	}

	public void inserir(Locadora locadora) {
		locadora.setId(new Long(0));
		_repository.save(locadora);
	}

	public List<Locadora> listar() {
		return _repository.findAll();
	}

}
