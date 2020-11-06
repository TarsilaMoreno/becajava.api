package br.api.locadora.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.api.locadora.model.Locacao;
import br.api.locadora.repository.LocacaoRepository;

@Service
public class LocacaoService {

	final LocacaoRepository _repository;

	@Autowired
	public LocacaoService(LocacaoRepository repository) {
		_repository = repository;
	}

	public void inserir(Locacao locacao) {
		_repository.save(locacao);
	}

	public List<Locacao> listar() {
		return _repository.findAll();
	}

}
