package br.api.locadora.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.api.locadora.model.Cliente;
import br.api.locadora.model.Veiculo;
import br.api.locadora.service.VeiculoService;

@RestController
@RequestMapping("/veiculo")
public class VeiculoController {

	private final VeiculoService _service;

	@Autowired
	public VeiculoController(VeiculoService service) {
		_service = service;
	}

	@PostMapping
	public ResponseEntity inserir(@RequestBody Veiculo veiculo) {
		_service.inserir(veiculo);
		return ResponseEntity.status(HttpStatus.CREATED).body("Veículo inserido com sucesso!");
	}

	@PutMapping(path = "/{id}")
	public ResponseEntity atualizar(@RequestBody Veiculo veiculo, @PathVariable Long id) {
		return ResponseEntity.status(HttpStatus.OK).body(veiculo);
	}

	@DeleteMapping(path = "/{id}")
	public ResponseEntity delete(@PathVariable Long id) {
		return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
	}
}
