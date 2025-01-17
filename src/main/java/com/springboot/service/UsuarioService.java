package com.springboot.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import com.springboot.model.Rol;
import com.springboot.model.Usuario;
import com.springboot.repository.RolRespository;
import com.springboot.repository.UsuarioRepository;

@Service
public class UsuarioService implements UserDetailsService{

	@Autowired
	private UsuarioRepository repositoryUsuario;
	@Autowired
	private RolRespository repositoryRol;
	
	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		Usuario user=repositoryUsuario.findByUsername(username);
		List<GrantedAuthority>roles=new ArrayList<>();
		for(Rol role: user.getRol()) {
			//ADMIN, SUPERVISOR, ESTUDIANTE U OTROS
			roles.add(new SimpleGrantedAuthority(role.getRolname()));
		}
		UserDetails userdet=new User(user.getUsername(), user.getPassword(), roles);
		return userdet;
	}

	public void saveUserWithDefaultRole(Usuario usuario) {
		BCryptPasswordEncoder encoder=new BCryptPasswordEncoder();
		String encodedPassword=encoder.encode(usuario.getPassword());
		usuario.setPassword(encodedPassword);
		
		Rol rolusuario=repositoryRol.findByRolname("ADMIN");
		usuario.addRol(rolusuario);
		
		repositoryUsuario.save(usuario);
	}
	
	public void actualizar(Usuario usuario) {
		BCryptPasswordEncoder encoder=new BCryptPasswordEncoder();
		String encodedPassword=encoder.encode(usuario.getPassword());
		usuario.setPassword(encodedPassword);
		
		repositoryUsuario.save(usuario);
	}
	
	public List<Usuario>listAll(){
		return repositoryUsuario.findAll();
	}
	
	public Usuario get(long id) {
		return repositoryUsuario.findById(id).get();
	}
	
	public List<Rol>getRol(){
		return repositoryRol.findAll();
	}

	public void eliminar(long id) {
		repositoryUsuario.deleteById(id);
		
	}
	
}
