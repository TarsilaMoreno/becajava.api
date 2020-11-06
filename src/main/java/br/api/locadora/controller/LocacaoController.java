package br.api.locadora.controller;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import br.api.locadora.model.Cliente;
import br.api.locadora.model.Locacao;
import br.api.locadora.service.LocacaoService;

@RestController
@RequestMapping("/locacao")
public class LocacaoController {

	private final LocacaoService _service;

	@Autowired
	public LocacaoController(LocacaoService service) {
		_service = service;
	}

	@PostMapping
	public ResponseEntity inserir(@RequestBody Locacao locacao) {
		_service.inserir(locacao);
		return ResponseEntity.status(HttpStatus.CREATED).body("Locação inserida com sucesso!");
	}

	@GetMapping
	public ResponseEntity listar() {
		Iterable<Locacao> locacao = _service.listar();
		return ResponseEntity.status(HttpStatus.OK).body(locacao);
	}

	@PutMapping(path = "/{id}")
	public ResponseEntity atualizar(@RequestBody Locacao locacao, @PathVariable Long id) {
		return ResponseEntity.status(HttpStatus.OK).body(locacao);
	}

	@DeleteMapping(path = "/{id}")
	public ResponseEntity delete(@PathVariable Long id) {
		return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
	}
}
