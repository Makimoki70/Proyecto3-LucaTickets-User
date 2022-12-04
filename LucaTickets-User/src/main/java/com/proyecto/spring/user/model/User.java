package com.proyecto.spring.user.model;

import java.sql.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import com.proyecto.spring.user.model.response.DTOUser;

import lombok.Data;
import lombok.NoArgsConstructor;
/**
 * 
 * @author Joel Pascual Mahindo
 * @version 0.1
 * @since 0.1
 * 
 * */

@NoArgsConstructor
@Entity
@Data
public class User {
	
	/**
	 * 
	 * @param id: Campo identificativo del resgistro
	 * 
	 * */
	@Id
	@GeneratedValue (strategy = GenerationType.IDENTITY)
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
	 * @param amail: Correo electrónico del usuario
	 * 
	 * */
	private String mail;
	
	/**
	 * 
	 * @param contraseña: Contraseña de la cuenta
	 * 
	 * */
	private String pass;
	
	/**
	 * 
	 * @param Fecha de alta: Cuando se dió de alta en la aplicación
	 * 
	 * */
	
	private Date fecha_alta;
	
}
