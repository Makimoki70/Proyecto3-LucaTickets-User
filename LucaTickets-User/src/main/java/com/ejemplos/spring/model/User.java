package com.ejemplos.spring.model;

import java.time.LocalDate;

import javax.validation.constraints.Max;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Positive;
import javax.validation.constraints.Size;

public class User {
	private Long id;
	@NotEmpty(message = "El nombre no debe ser vacío")
	private String nombre;
	@NotEmpty(message = "Necesitamos que indiques un apellido")	
	private String apellido;
	@NotEmpty(message = "Necesitamos un correo electrónico")	
	private String mail;
	@NotEmpty(message = "Necesitamos que indiques una contraseña")
	private String pass;
	private LocalDate fecha_alta;
	public User(Long id, @NotEmpty(message = "El nombre no debe ser vacío") String nombre,
			@NotEmpty(message = "Necesitamos que indiques un apellido") String apellido,
			@NotEmpty(message = "Necesitamos un correo electrónico") String mail,
			@NotEmpty(message = "Necesitamos que indiques una contraseña") String pass, LocalDate fecha_alta) {
		super();
		this.id = id;
		this.nombre = nombre;
		this.apellido = apellido;
		this.mail = mail;
		this.pass = pass;
		this.fecha_alta = fecha_alta;
	}
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	public String getApellido() {
		return apellido;
	}
	public void setApellido(String apellido) {
		this.apellido = apellido;
	}
	public String getMail() {
		return mail;
	}
	public void setMail(String mail) {
		this.mail = mail;
	}
	public String getPass() {
		return pass;
	}
	public void setPass(String pass) {
		this.pass = pass;
	}
	public LocalDate getFecha_alta() {
		return fecha_alta;
	}
	public void setFecha_alta(LocalDate fecha_alta) {
		this.fecha_alta = fecha_alta;
	}

	
}