package com.rcm.repository;

import org.springframework.data.repository.CrudRepository;

import com.rcm.models.User;

//ESSA CLASSE JA POSSUI TODOS OS METHODOS DE LISTAR ,ATUALIZAR, DELETAR E INSERIR
public interface UserRepository extends CrudRepository<User, Long>{
	
}
