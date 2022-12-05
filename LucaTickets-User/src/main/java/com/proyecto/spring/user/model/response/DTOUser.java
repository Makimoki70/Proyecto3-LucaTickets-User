package com.proyecto.spring.user.model.response;

import java.io.Serializable;
import java.time.LocalDate;

import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * 
 * Nombre de clase: DTOUser.
 * Descripcion: model DTO, para poder hacer adaptacion entre la clase User y esta, de cara a MySQL
 * Fecha: 05/12/2022
 * @author David Gomez Arellano
 * @version 0.1
 * @since 0.1
 * 
 * */

@Data @NoArgsConstructor
public class DTOUser implements Serializable {

	private static final long serialVersionUID = 1L;
	
	/**
	 * 
	 * @param id: Campo identificativo del resgistro
	 * 
	 * */
	private Long id;
	
	/**
	 * 
	 * @param nombre: Como se llama el usuario
	 * 
	 * */
	private String nombre;
	
	/**
	 * 
	 * @param apellido: Como se apellida el usuario
	 * 
	 * */
	private String apellido;
	
	/**
	 * 
	 * @param mail: Correo electrónico del usuario
	 * 
	 * */
	private String mail;
	
	/**
	 * 
	 * @param pass: Contraseña de la cuenta
	 * 
	 * */
	private String pass;
	
	/**
	 * 
	 * @param Fecha de alta: Cuando se dió de alta en la aplicación
	 * 
	 * */
	private LocalDate fecha_alta;
}