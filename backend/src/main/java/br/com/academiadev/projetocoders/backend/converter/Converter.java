package br.com.academiadev.projetocoders.backend.converter;

public interface Converter<T, D> {
	
	public D toDTO(T entity);

	public T toEntity(D dto);

}
