package com.rodrigues.user.crud.model.entities;

import java.io.Serializable;
import java.util.Objects;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import com.rodrigues.user.crud.dto.UserDTO;

@Entity
public class User implements Serializable{

	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	private String name;
	private String cpf;
	private String telefone;
	
	
	public User() {}


	public User(Long id, String name, String cpf, String telefone) {
		super();
		this.id = id;
		this.name = name;
		this.cpf = cpf;
		this.telefone = telefone;
	}

	public static User convert(UserDTO userDTO) {
		User user = new User();
		user.setId(userDTO.getId());
		user.setName(userDTO.getName());
		user.setCpf(userDTO.getCpf());
		user.setTelefone(userDTO.getTelefone());
		
		
		return user;
	}
	
	public Long getId() {
		return id;
	}


	public void setId(Long id) {
		this.id = id;
	}


	public String getName() {
		return name;
	}


	public void setName(String name) {
		this.name = name;
	}


	public String getCpf() {
		return cpf;
	}


	public void setCpf(String cpf) {
		this.cpf = cpf;
	}


	public String getTelefone() {
		return telefone;
	}


	public void setTelefone(String telefone) {
		this.telefone = telefone;
	}


	@Override
	public int hashCode() {
		return Objects.hash(id);
	}


	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		User other = (User) obj;
		return Objects.equals(id, other.id);
	}
	
	

}
