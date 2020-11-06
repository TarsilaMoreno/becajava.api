package br.api.locadora.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import br.api.locadora.model.Cliente;
import br.api.locadora.service.ClienteService;

@RestController
@RequestMapping("/cliente")
public class ClienteController {

	final ClienteService _service;

	@Autowired
	public ClienteController(ClienteService service) {
		_service = service;
	}

	@PostMapping
	public ResponseEntity inserir(@RequestBody Cliente cliente) {
		_service.inserir(cliente);
		return ResponseEntity.status(HttpStatus.CREATED).body(cliente);
	}

	@GetMapping
	public ResponseEntity listar() {
		Iterable<Cliente> cliente = _service.listar();
		return ResponseEntity.status(HttpStatus.OK).body(cliente);

	}

	@PutMapping(path = "/{id}")
	public ResponseEntity atualizar(@RequestBody Cliente cliente, @PathVariable Long id) {
		cliente.setId(id);
		_service.atualizar(cliente);
		return ResponseEntity.status(HttpStatus.OK).body(cliente);
	}

	@DeleteMapping(path = "/{id}")
	public ResponseEntity delete(@PathVariable Long id) {
		_service.deletar(id);
		return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
	}
}
