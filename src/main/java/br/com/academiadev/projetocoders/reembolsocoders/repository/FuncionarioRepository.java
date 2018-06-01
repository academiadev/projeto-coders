package br.com.academiadev.projetocoders.reembolsocoders.repository;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import br.com.academiadev.projetocoders.reembolsocoders.model.Funcionario;

@Repository
public interface FuncionarioRepository extends CrudRepository<Funcionario, Long>{
	
	public Funcionario findByNome(String nome);
	
	public List<Funcionario> findByEmpresaId(Long empresa_id);
	
}
