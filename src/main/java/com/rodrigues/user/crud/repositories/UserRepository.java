package com.rodrigues.user.crud.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.rodrigues.user.crud.model.entities.User;

@Repository
public interface UserRepository extends JpaRepository<User, Long>{

	List<User> queryByNameContaining(String name);
}
