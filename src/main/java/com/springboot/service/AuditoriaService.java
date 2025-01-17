package com.springboot.service;

import java.util.List;
import java.util.Optional;
import com.springboot.model.Auditoria;

public interface AuditoriaService {
	public List<Auditoria>listarTodos();
	public void guardar(Auditoria auditoria);	
	public void eliminar(Long id);	
	public Auditoria findOne (Long id);
	public Optional<Auditoria>buscarId(Long id);
	
}
