package com.teste.fast.dto;

import com.teste.fast.model.Endereco;
import com.teste.fast.model.Pessoa;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class PessoaDTO {
	
	private String nome;
	private Integer idade;
	private Endereco endereco;
	
	
	public static Pessoa toPessoa(PessoaDTO pessoaDTO) {
		Pessoa pessoa = new Pessoa();
		pessoa.setNome(pessoaDTO.getNome());
		pessoa.setIdade(pessoaDTO.getIdade());
		pessoa.setEndereco(pessoaDTO.getEndereco());
		return pessoa;
	}
}
