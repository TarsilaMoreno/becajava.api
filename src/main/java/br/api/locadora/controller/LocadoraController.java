package br.api.locadora.controller;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import br.api.locadora.model.Cliente;
import br.api.locadora.model.Locadora;
import br.api.locadora.service.LocadoraService;

@RestController
@RequestMapping("/locadora")
public class LocadoraController {

	private final LocadoraService _service;

	@Autowired
	public LocadoraController(LocadoraService service) {
		_service = service;
	}

	@PostMapping
	public ResponseEntity inserir(@RequestBody Locadora locadora) {
		_service.inserir(locadora);
		return ResponseEntity.status(HttpStatus.CREATED).body("Locadora inserido com sucesso!");
	}

	@GetMapping
	public ResponseEntity listar() {
		Iterable<Locadora> locadora = _service.listar();
		return ResponseEntity.status(HttpStatus.OK).body(locadora);
	}

	@PutMapping(path = "/{id}")
	public ResponseEntity atualizar(@RequestBody Locadora locadora, @PathVariable Long id) {
		return ResponseEntity.status(HttpStatus.OK).body(locadora);
	}

	@DeleteMapping(path = "/{id}")
	public ResponseEntity delete(@PathVariable Long id) {
		return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
	}
}
