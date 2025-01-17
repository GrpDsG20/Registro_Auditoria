package com.springboot.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.springboot.model.Rol;

@Repository
public interface RolRespository extends JpaRepository<Rol, Long>{

	public Rol findByRolname(String rolname);
}
