package com.springboot.repository;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.springboot.model.Auditoria;

@Repository
public interface AuditoriaRepository extends JpaRepository<Auditoria, Long>{
	 
}
