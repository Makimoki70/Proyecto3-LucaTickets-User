package com.proyecto.spring.user.model;

import java.sql.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.Size;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;
import lombok.NoArgsConstructor;
/**
 * 
 * Nombre de clase: User.
 * Descripcion: Clase model del microservicio User. 
 * Fecha: 05/12/2022
 * @author Joel Pascual Mahindo
 * @version 0.1
 * @since 0.1
 * 
 * */

@NoArgsConstructor
@Entity
@Data
@Schema(name="User", description = "User Class")
@Table(name = "user")
public class User {
	
	/**
	 * 
	 * @param id: Campo identificativo del resgistro
	 * 
	 * */
	@Id
	@GeneratedValue (strategy = GenerationType.IDENTITY)
	@Schema(name= "id", 
	description = "Identificador único para el usuario", 
    example = "42", 
    required = true)
	private Long id;
	
	/**
	 * 
	 * @param nombre: Como se llama el usuario
	 * 
	 * */
	@Size(min = 0, max = 45)
	private String nombre;	
	
	/**
	 * 
	 * @param apellido: Como se apellida el usuario
	 * 
	 * */
	@Size(min = 0, max = 45)
	private String apellido;
	
	/**
	 * 
	 * @param amail: Correo electrónico del usuario
	 * 
	 * */
	@Size(min = 0, max = 45)
	private String mail;
	
	/**
	 * 
	 * @param pass: Contraseña de la cuenta
	 * 
	 * */
	@Size(min = 0, max = 45)
	private String pass;
	
	/**
	 * 
	 * @param Fecha de alta: Cuando se dió de alta en la aplicación
	 * 
	 * */
	
	private Date fecha_alta;
	
}
