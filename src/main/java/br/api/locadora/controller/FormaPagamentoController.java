package br.api.locadora.controller;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import br.api.locadora.model.Cliente;
import br.api.locadora.model.FormaPagamento;
import br.api.locadora.service.FormaPagamentoService;

@RestController
@RequestMapping("/pagamento")
public class FormaPagamentoController {

	private final FormaPagamentoService _service;

	@Autowired
	public FormaPagamentoController(FormaPagamentoService service) {
		_service = service;
	}

	@PostMapping
	public ResponseEntity inserir(@RequestBody FormaPagamento pagamento) {
		_service.inserir(pagamento);
		return ResponseEntity.status(HttpStatus.CREATED).body("Pagamento inserido com sucesso!");
	}

	@GetMapping
	public ResponseEntity listar() {
		Iterable<FormaPagamento> pagamento = _service.listar();
		return ResponseEntity.status(HttpStatus.OK).body(pagamento);
	}

	@PutMapping(path = "/{id}")
	public ResponseEntity atualizar(@RequestBody FormaPagamento formaPagamento, @PathVariable Long id) {
		return ResponseEntity.status(HttpStatus.OK).body(formaPagamento);
	}

	@DeleteMapping(path = "/{id}")
	public ResponseEntity delete(@PathVariable Long id) {
		return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
	}
}
