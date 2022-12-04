package com.proyecto.spring.user.model.adapter;

import java.sql.Date;
import java.time.LocalDate;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import javax.persistence.AttributeConverter;
import javax.persistence.Converter;

import org.hibernate.mapping.Map;
import org.springframework.stereotype.Component;

import com.proyecto.spring.user.model.User;
import com.proyecto.spring.user.model.response.DTOUser;


@Component
@Converter(autoApply = true)
public class UserDateAdapter implements AttributeConverter<LocalDate, Date> {
	
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

	
    @Override
    public LocalDate convertToEntityAttribute(Date date) {
        return Optional.ofNullable(date)
          .map(Date::toLocalDate)
          .orElse(null);
    }
    
    @Override
    public Date convertToDatabaseColumn(LocalDate localDate) {
        return Optional.ofNullable(localDate)
          .map(Date::valueOf)
          .orElse(null);
    }
}
