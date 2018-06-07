package br.com.academiadev.projetocoders.reembolsocoders.repository;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import br.com.academiadev.projetocoders.reembolsocoders.model.Usuario;

@Repository
public interface UsuarioRepository extends CrudRepository<Usuario, Long>{
	
	public Usuario findByNome(String nome);
	
	public Usuario findByEmail(String email);

	public List<Usuario> findByEmpresaId(Long empresa_id);
	
}
