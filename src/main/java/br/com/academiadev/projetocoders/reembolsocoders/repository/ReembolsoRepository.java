package br.com.academiadev.projetocoders.reembolsocoders.repository;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import br.com.academiadev.projetocoders.reembolsocoders.model.Reembolso;

@Repository
public interface ReembolsoRepository extends CrudRepository<Reembolso, Long> {
	
	public List<Reembolso> findByUsuarioIdAndExcluido(Long funcionario_id, Boolean excluido);
	
	public List<Reembolso> findByCategoriaAndExcluido(String categoria, Boolean excluido);
	
	public List<Reembolso> findByUsuario_Empresa_id(Long id);

}
