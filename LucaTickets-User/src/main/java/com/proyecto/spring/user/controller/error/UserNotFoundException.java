package com.proyecto.spring.user.controller.error;

public class UserNotFoundException extends RuntimeException{
	private static final long serialVersionUID = 1L;

	public UserNotFoundException(){
		super("Error: No existe ese usuario");
	}
	public UserNotFoundException(Long id){
		super("Ups: No existe el usuario "+id);
	}
}