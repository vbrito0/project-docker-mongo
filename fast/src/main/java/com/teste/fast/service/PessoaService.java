package com.teste.fast.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.teste.fast.dto.PessoaDTO;
import com.teste.fast.model.Pessoa;
import com.teste.fast.repository.PessoaRepository;

@Service
public class PessoaService {
	
	private static final String MSG_NOT_FOUND_PESSOA = "Essa pessoa não foi encontrada na base de dados";
	
	@Autowired
	private PessoaRepository pessoaRepository;
	
	public Pessoa criarPessoa(PessoaDTO pessoaDTO) {
		Pessoa pessoa = PessoaDTO.toPessoa(pessoaDTO);
		return pessoaRepository.save(pessoa);
	}
	
	public List<Pessoa> buscarPessoas() {
		return pessoaRepository.findAll();
	}

	public Pessoa buscarPorId(String id) {
		Pessoa pessoa = pessoaRepository.findById(id).orElseThrow(() -> new IllegalArgumentException(MSG_NOT_FOUND_PESSOA));
		return pessoa;
	}
	
}
