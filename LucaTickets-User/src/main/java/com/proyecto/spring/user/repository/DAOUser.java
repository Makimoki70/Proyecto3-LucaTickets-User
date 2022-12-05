package com.proyecto.spring.user.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.proyecto.spring.user.model.User;

/**
 * 
 * Nombre de clase: DAOUser
 * Descripcion: Interfaz de repositorio del microservicio User. Al ser JPA, implementa todos los metodos de base de datos
 * Fecha: 05/12/2022
 * @author David Gomez Arellano
 * @version 0.1
 * @since 0.1
 * 
 * */

public interface DAOUser extends JpaRepository<User, Long>{

}
