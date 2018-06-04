package br.com.academiadev.projetocoders.reembolsocoders.repository;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import br.com.academiadev.projetocoders.reembolsocoders.model.Reembolso;

@Repository
public interface ReembolsoRepository extends CrudRepository<Reembolso, Long> {
	
	public List<Reembolso> findByUsuarioId(Long funcionario_id);
	
	public List<Reembolso> findByCategoria(String categoria);
	
//	@Query("select rb from reembolso rb inner join usuario us on (rb.usuario_id=us.id) inner join empresa em on (us.empresa_id=em.id) where em.codigo = ?1")
//	public List<Reembolso> findAllPorEmpresa(Integer empresa_codigo);

}
