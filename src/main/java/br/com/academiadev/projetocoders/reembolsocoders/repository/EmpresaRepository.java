package br.com.academiadev.projetocoders.reembolsocoders.repository;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import br.com.academiadev.projetocoders.reembolsocoders.model.Empresa;

@Repository
public interface EmpresaRepository extends CrudRepository<Empresa, Long> {

	public Empresa findByCodigo(Integer codigo);

	public Empresa findByNome(String nome);

	@Query("SELECT max(codigo) from Empresa")
	public Integer findMaxCodigo();

}
