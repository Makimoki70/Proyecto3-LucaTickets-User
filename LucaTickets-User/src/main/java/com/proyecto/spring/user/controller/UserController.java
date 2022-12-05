package com.proyecto.spring.user.controller;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.proyecto.spring.user.model.User;
import com.proyecto.spring.user.model.adapter.UserDateAdapter;
import com.proyecto.spring.user.model.response.DTOUser;
import com.proyecto.spring.user.service.UserService;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;

/**
 * 
 * Nombre de clase: UserController. Descripcion: Controlador del microservicio
 * User. Implementa el metodo add a la base de datos y enlaza con el adapter
 * Fecha: 05/12/2022
 * 
 * @author Alberto Egea Garcia y David Gomez Arellano
 * @version 0.2
 * @since 0.1
 * 
 */

@RestController
@RequestMapping("/user")
@Tag(name = "user", description = "the user API controller")
public class UserController {

	@Autowired
	private UserService userService;

	@Autowired
	private UserDateAdapter adapter;

	/**
	 * Método que añade un usuario a la base de datos
	 * 
	 * @return opcionalmente, el usuario convertido a DTO
	 */
	@Operation(summary = "Añadir Usuario", description = "Dado un usuario por DTO, devolverlo tratado para la base de datos SQL", tags = {
			"user" })
	@ApiResponses(value = {
			@ApiResponse(responseCode = "201", description = "Usuario insertado correctamente", content = {
					@Content(mediaType = "application/json", schema = @Schema(implementation = User.class)) }),
			@ApiResponse(responseCode = "401", description = "Usuario no válido (NO introducido) ", content = @Content),
			@ApiResponse(responseCode = "404", description = "Tabla no localizada (NO introducido)", content = @Content),

			@ApiResponse(responseCode = "501", description = "Error de servidor, Podria no estar activado?", content = @Content) }

	)
	@PostMapping("/add")
	public ResponseEntity<DTOUser> saveUser(@RequestBody DTOUser user) {
		User result = userService.addUser(adapter.convertToEntity(user));
		return ResponseEntity.of(Optional.of(adapter.convertToDto(result)));
	}
}
