package com.rodrigues.user.crud.controllers;

import java.io.Serializable;
import java.net.URI;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.rodrigues.user.crud.dto.UserDTO;
import com.rodrigues.user.crud.services.UserService;

@Controller
@RequestMapping("/users")
public class UserController implements Serializable{
	private static final long serialVersionUID = 1L;

	@Autowired
	private UserService userService;

	@PostMapping
	public ResponseEntity<UserDTO> saved(@RequestBody UserDTO userDTO) {
		var obj = userService.saved(userDTO);
		
		URI uri = ServletUriComponentsBuilder
                .fromCurrentRequest().path("/{id}")
                .buildAndExpand(obj.getId()).toUri();
		
		return ResponseEntity.created(uri).build();
	}

	@GetMapping
	public ResponseEntity<List<UserDTO>> getAll() {
		return ResponseEntity.ok().body(userService.getAll());
	}
	
	
	@GetMapping("/{id}")
	public ResponseEntity<UserDTO> findId(@PathVariable Long id) {
		return ResponseEntity.ok().body(userService.findId(id));
	}
	
	@DeleteMapping("/{id}")
	public ResponseEntity<Void> delete(@PathVariable Long id) {
		
		userService.delete(id);
		
		return ResponseEntity.noContent().build();
	}
	
	@GetMapping("/search")
	public ResponseEntity<List<UserDTO>> findByName(@RequestParam(name = "name", required = true) String name) {
		return ResponseEntity.ok().body(userService.findByName(name));
	}
	
	@PutMapping("/{id}")
	public ResponseEntity<UserDTO> update(@PathVariable Long id, @RequestBody UserDTO userDTO) {
		return ResponseEntity.ok().body(userService.update(id, userDTO));
	}
}
