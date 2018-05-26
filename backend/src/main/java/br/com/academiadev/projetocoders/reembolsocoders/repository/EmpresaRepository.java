package br.com.academiadev.projetocoders.reembolsocoders.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import br.com.academiadev.projetocoders.reembolsocoders.model.Empresa;
import br.com.academiadev.projetocoders.reembolsocoders.model.Funcionario;

@Repository
public interface EmpresaRepository extends CrudRepository<Empresa, Long>{
	
	public Empresa findByCodigo(Long codigo);
	
	public Empresa findByNome(String nome);

}
