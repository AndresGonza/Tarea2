package com.ug.encuesta.repository;



import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import java.util.List;
import com.ug.encuesta.dominio.Grupo;

public interface GrupoRepository extends CrudRepository<Grupo, Integer>{
	@Query("Selectcom.ug.encuesta.dominio.Grupo(g.grupo_id, g.literal, g.descripcion) from grupos g")
	public List<Grupo> getGrupo();
	
public List<Grupo> findByLiteral(String arg);
public List<Grupo> findByLiteralAndDescripcion(String arg,String desc);
public List<Grupo> findByLiteralOrDescripcion(String arg,String desc);
}
