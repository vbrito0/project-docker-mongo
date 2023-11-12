package com.teste.fast.repository;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import com.teste.fast.model.Pessoa;

@Repository
public interface PessoaRepository extends MongoRepository<Pessoa, String>{
	
}
