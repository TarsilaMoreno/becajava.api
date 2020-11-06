package br.api.locadora.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.api.locadora.model.Locadora;
import br.api.locadora.model.Veiculo;
import br.api.locadora.repository.LocadoraRepository;
import br.api.locadora.repository.VeiculoRepository;

@Service
public class VeiculoService {
	
	final VeiculoRepository _repository;

	@Autowired
	public VeiculoService(VeiculoRepository repository) {
		_repository = repository;
	}

	public void inserir(Veiculo veiculo) {
		veiculo.setId(new Long(0));
		_repository.save(veiculo);
	}

	public List<Veiculo> listar() {
		return _repository.findAll();
	}

}


