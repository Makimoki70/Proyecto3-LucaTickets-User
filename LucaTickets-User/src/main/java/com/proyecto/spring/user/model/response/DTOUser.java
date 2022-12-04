package com.proyecto.spring.user.model.response;

import java.io.Serializable;
import java.time.LocalDate;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data @NoArgsConstructor
public class DTOUser implements Serializable {

	private static final long serialVersionUID = 1L;
	
	private Long id;
	private String nombre;
	private String apellido;
	private String mail;
	private String pass;
	private LocalDate fecha_alta;
}