package com.rcm.models;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotBlank;

@Entity //CLASSE QUE REFERENCIA TABELA NO BANCO 
@Table(name = "alunos")
public class Alunos {
	@Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;
     
    @NotBlank(message = "Nome is mandatory")
    private String nome;
     
    @NotBlank(message = "Email is mandatory")
    private String email;

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	@Override
	public String toString() {
		return "Alunos [id=" + id + ", nome=" + nome + ", email=" + email + "]";
	}
    
}
