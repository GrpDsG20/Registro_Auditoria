package com.springboot.serviceImpl;

import java.util.List;

import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.springboot.model.Auditoria;
import com.springboot.repository.AuditoriaRepository;
import com.springboot.service.AuditoriaService;

@Service
public class AuditoriaServiceImpl implements AuditoriaService{
	
	@Autowired
	private AuditoriaRepository repository;

	@Override
	public List<Auditoria> listarTodos() {
		return repository.findAll();
	}

	@Override
	public void guardar(Auditoria auditoria) {
		repository.save(auditoria);
		
	}

	@Override
	@Transactional
	public void eliminar(Long id) {
		repository.deleteById(id);
		
	}

	@Override
	@Transactional(readOnly = true)
	public Auditoria findOne(Long id) {
		return repository.findById(id).orElse(null);
	}

	@Override
    public Optional<Auditoria> buscarId(Long id) {
        return repository.findById((Long) id);
    }
}
