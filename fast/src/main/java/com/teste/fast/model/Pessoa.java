package com.teste.fast.model;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Document
public class Pessoa {

	@Id
	private String id;
	private String nome;
	private Integer idade;
	private Endereco endereco;
}
