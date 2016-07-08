package com.ug.encuesta.repository;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;


import com.ug.encuesta.dominio.Subgrupo;

public interface SubgrupoRepository extends CrudRepository<Subgrupo, Integer> {
//de esta forma vamos a consultar los subgrupos de un grupo//
	//consulta en hql
	//@Query("Select s from subgrupos s where s.grupo.grupo_id=?1 ")
	//conulta nativa
	@Query(value="Select s.* from subgrupos s where s.grupo.grupo_id=?1 ", nativeQuery= true)
	List<Subgrupo> getSubgrupoByGrupo(int grupo_id);
	
	
}
