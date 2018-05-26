package br.com.academiadev.projetocoders.reembolsocoders.converter;

import java.sql.Date;
import java.time.LocalDate;

import javax.persistence.AttributeConverter;
import javax.persistence.Converter;

@Converter(autoApply = true)
public class LocalDateAttributeConversor implements AttributeConverter<LocalDate, Date> {

	@Override
	public Date convertToDatabaseColumn(LocalDate attribute) {
		return attribute != null ? Date.valueOf(attribute) : null; 
	}

	@Override
	public LocalDate convertToEntityAttribute(Date dbData) {
		return dbData != null ? dbData.toLocalDate() : null;
	}

}
