package com.proyecto.spring.user.model.adapter;

import java.sql.Date;
import java.time.LocalDate;
import java.util.Optional;

import javax.persistence.AttributeConverter;
import javax.persistence.Converter;

import org.springframework.stereotype.Component;

import com.proyecto.spring.user.model.User;
import com.proyecto.spring.user.model.response.DTOUser;

/**
 * 
 * Nombre de clase; UserDateAdapter.
 * Descripcion: La clase adapter, contiene los metodos para convertir datos a SQL de cara a base de datos, y viceversa
 * Fecha: 05/12/2022
 * @author Alberto Egea Garcia y David Gomez Arellano
 * @version 0.3
 * @since 0.1
 * 
 * */

@Component
@Converter(autoApply = true)
public class UserDateAdapter implements AttributeConverter<LocalDate, Date> {
	
	/**
     * Método que convierte los datos del usuario a DTO, para ser tratado y adherido en base de datos SQL
     * @return El usuario con la fecha tratada y modificada para ser introducida en la base de datos
     */
	//Conversor a SQL
	public DTOUser convertToDto(User user) {
        DTOUser dtoUser = new DTOUser();
        dtoUser.setId(user.getId());
        dtoUser.setNombre(user.getNombre());
        dtoUser.setApellido(user.getApellido());
        dtoUser.setMail(user.getMail());
        dtoUser.setPass(user.getPass());
        dtoUser.setFecha_alta(convertToEntityAttribute(user.getFecha_alta()));
        
        return dtoUser;
    }
	
	/**
     * Método que convierte los datos DTO extraidos del objeto en base de datos, a valores entity de java
     * @return El entity User 
     */
	//Conversor a java
	public User convertToEntity(DTOUser dtoUser){
	    User user = new User();
	    user.setId(dtoUser.getId());
        user.setNombre(dtoUser.getNombre());
        user.setApellido(dtoUser.getApellido());
        user.setMail(dtoUser.getMail());
        user.setPass(dtoUser.getPass());
        user.setFecha_alta(convertToDatabaseColumn(dtoUser.getFecha_alta()));
        
	    return user ;
	}

	/**
     * Método interno del método convertToDto que modifica el campo fecha (Date) a fecha(LocalDate), para poder ser tratado de forma SQL
     * @return el campo date modificado
     */
    @Override
    public LocalDate convertToEntityAttribute(Date date) {
        return Optional.ofNullable(date)
          .map(Date::toLocalDate)
          .orElse(null);
    }
    
    /**
     * Método interno del método convertToEntity que modifica el campo fecha (LocalDate) a fecha(Date), para poder ser tratado por java
     * @return el campo date modificado
     */
    @Override
    public Date convertToDatabaseColumn(LocalDate localDate) {
        return Optional.ofNullable(localDate)
          .map(Date::valueOf)
          .orElse(null);
    }
}
