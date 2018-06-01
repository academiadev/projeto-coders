package br.com.academiadev.projetocoders.reembolsocoders.repository;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import br.com.academiadev.projetocoders.reembolsocoders.model.Reembolso;

@Repository
public interface ReembolsoRepository extends CrudRepository<Reembolso, Long> {
	
	public List<Reembolso> findByFuncionarioId(Long funcionario_id);
	
	public List<Reembolso> findByCategoria(String categoria);

}
