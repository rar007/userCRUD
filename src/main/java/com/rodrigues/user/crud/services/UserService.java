package com.rodrigues.user.crud.services;

import java.io.Serializable;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.rodrigues.user.crud.dto.UserDTO;
import com.rodrigues.user.crud.model.entities.User;
import com.rodrigues.user.crud.repositories.UserRepository;

@Service
public class UserService implements Serializable{
	
	private static final long serialVersionUID = 1L;
	
	
	@Autowired
	private UserRepository userRepository;
	
	// Salva os usuarios
	public UserDTO saved(UserDTO userDTO) {
		
		userDTO.setId(null);
		User user = userRepository.save(User.convert(userDTO));
		return UserDTO.convertToDTO(user);
	}

	// Listar todos os usuarios
	public List<UserDTO> getAll() {
		List<User> users = userRepository.findAll();

		return users.stream()
				.map(UserDTO::convertToDTO)
				.collect(Collectors.toList());
	}
	
	// Pesquisar usuario por ID
	public UserDTO findId(Long id) {
		Optional<User> user = userRepository.findById(id);
		if(user != null) {
			return UserDTO.convertToDTO(user.get());
		}
		return null;
	}
	
	// Pesquisar usuario pelo nome ou por partes do nome
	public List<UserDTO> findByName(String name) {
		List<User> users = userRepository.queryByNameContaining(name);
		
		return users.stream().map(x -> UserDTO.convertToDTO(x))
				.collect(Collectors.toList());
	}
	
	// Atualizar usuario total
	public UserDTO update(Long id, UserDTO userDTO) {
		userDTO.setId(id);
		User user = userRepository.save(User.convert(userDTO));
		return UserDTO.convertToDTO(user);
	}
	
	
	// Deletar usuario
	public void delete(Long id) {
		if(findId(id) != null) {
			userRepository.deleteById(id);
		}
	}

}
