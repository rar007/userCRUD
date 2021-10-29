package com.rodrigues.user.crud.dto;

import java.io.Serializable;

import com.rodrigues.user.crud.model.entities.User;

public class UserDTO implements Serializable{
	private static final long serialVersionUID = 1L;
	
	
	private Long id;
	private String name;
	private String cpf;
	private String telefone;
	
	public UserDTO() {}

	public UserDTO(Long id, String name, String cpf, String telegone) {
		super();
		this.id = id;
		this.name = name;
		this.cpf = cpf;
		this.telefone = telegone;
	}

	public static UserDTO convertToDTO(User user) {
		UserDTO userDTO = new UserDTO();
		userDTO.setId(user.getId());
		userDTO.setName(user.getName());
		userDTO.setCpf(user.getCpf());
		userDTO.setTelefone(user.getTelefone());
		
		
		
		return userDTO;
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

	public void setTelefone(String telegone) {
		this.telefone = telegone;
	}
	
	

}
