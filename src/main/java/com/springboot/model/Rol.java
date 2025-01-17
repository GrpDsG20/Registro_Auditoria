package com.springboot.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "rol")
public class Rol {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column
	private long idrol;
	@Column
	private String rolname;
	
	// GET AND SET
	public long getIdrol() {
		return idrol;
	}
	public void setIdrol(long idrol) {
		this.idrol = idrol;
	}
	public String getRolname() {
		return rolname;
	}
	public void setRolname(String rolname) {
		this.rolname = rolname;
	}
	
	@Override
	public String toString() {
		return this.rolname;
	}
	
}
