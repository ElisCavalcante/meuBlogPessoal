package br.com.eliscavalcanteblog.projetomeublog.Repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.eliscavalcanteblog.projetomeublog.model.Tema;

public interface TemaRepository extends JpaRepository<Tema, Long>{
	public List<Tema> findAllByDescricaoContainingIgnoreCase(String descricao);
	
	
	
}
