package com.springboot.model;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.Table;

@Entity
@Table(name = "usuario")
public class Usuario {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column
	private long iduser;
	@Column
	private String username;
	@Column
	private String password;
	
	@ManyToMany(fetch = FetchType.EAGER)
	@JoinTable(name = "rol_usuario",
	joinColumns = @JoinColumn(name = "iduser"),
	inverseJoinColumns = @JoinColumn(name = "idrol"))
	private Set<Rol> rol=new HashSet<>();//AGREGAR EL =NEW HASHSET() PARA COMPLEMENTAR EL AGRERAR ROL AL USUARIO

	// GET AND SET
	public long getIduser() {
		return iduser;
	}

	public void setIduser(long iduser) {
		this.iduser = iduser;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public Set<Rol> getRol() {
		return rol;
	}

	public void setRol(Set<Rol> rol) {
		this.rol = rol;
	}
	
	//PARA AGREGAR UN ROL
	public void addRol(Rol rol) {
		this.rol.add(rol);
	}
	
}
