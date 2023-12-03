package com.teste.fast.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.teste.fast.dto.PessoaDTO;
import com.teste.fast.model.Pessoa;
import com.teste.fast.service.PessoaService;

@RestController
@RequestMapping("/pessoa")
public class PessoaController {

	@Autowired
	private PessoaService pessoaService;

	@PostMapping("/criar")
	private ResponseEntity<Pessoa> criar(@RequestBody PessoaDTO pessoaDTO) {
		Pessoa pessoa = pessoaService.criarPessoa(pessoaDTO);
		return ResponseEntity.status(HttpStatus.CREATED).body(pessoa);
	}

	@GetMapping
	private ResponseEntity<List<Pessoa>> buscarList() {
		List<Pessoa> buscarPessoas = pessoaService.buscarPessoas();
		return ResponseEntity.status(HttpStatus.FOUND).body(buscarPessoas);
	}

	@GetMapping("/{id}")
	private ResponseEntity<Pessoa> buscar(@PathVariable String id) {
		Pessoa buscarPessoa = pessoaService.buscarPorId(id);
		return ResponseEntity.status(HttpStatus.FOUND).body(buscarPessoa);
	}
}
