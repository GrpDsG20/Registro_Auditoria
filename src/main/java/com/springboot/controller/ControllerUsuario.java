package com.springboot.controller;

import java.util.List;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.springboot.model.Rol;
import com.springboot.model.Usuario;
import com.springboot.service.UsuarioService;

@Controller
public class ControllerUsuario {

	@Autowired
	private UsuarioService service;
	
	@GetMapping("/listaUsuarios")
	public String listausuarios(Model modelo) {
		List<Usuario>lista=service.listAll();
		modelo.addAttribute("listaUsuarios", lista);
		return "listadousuario";
	}
	
	@GetMapping("/agregarUsuario")
	public String agregarusuario(Model modelo) {
		List<Rol>listaRol=service.getRol();
		modelo.addAttribute("usuario", new Usuario());
		modelo.addAttribute("listaRoles", listaRol);
		return "registrousuario";
	}
	
	@PostMapping("/guardarUsuario")
	public String guardarusuario(Usuario usuario) {
		service.saveUserWithDefaultRole(usuario);
		return "redirect:/listaUsuarios";
	}
	
	@GetMapping("/editarUsuario/{id}")
	public String editarusuario(@PathVariable("id") long id, Model modelo) {
		Usuario usu=service.get(id);
		List<Rol>listaRol=service.getRol();
		modelo.addAttribute("usuario", usu);
		modelo.addAttribute("listaRoles", listaRol);
		return "editarusuario";
	}
	
	@PostMapping("/actualizarUsuario")
	public String actualizarusuario(Usuario usuario) {
		service.actualizar(usuario);
		return "redirect:/listaUsuarios";
	}
	
	
	@RequestMapping("/eliminarUsuario/{id}")
	public String eliminarUsuario(@PathVariable("id") long id) {
	    service.eliminar(id);
	    return "redirect:/listaUsuarios";
	}
}
