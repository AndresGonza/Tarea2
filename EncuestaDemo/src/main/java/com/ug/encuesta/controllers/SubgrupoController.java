package com.ug.encuesta.controllers;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;


import com.ug.encuesta.dominio.Subgrupo;
import com.ug.encuesta.repository.SubgrupoRepository;

@RestController
public class SubgrupoController {
	@Autowired
	private SubgrupoRepository subgrupoRepository;
	
	
	@RequestMapping(value="/subgrupos",method=RequestMethod.GET)
	public Iterable<Subgrupo> findAll(){
		return subgrupoRepository.findAll();
		
	}
	
	//de esta forma vamos a consultar los subgrupos de un grupo//
	@RequestMapping(value="/grupos/{grupo_id}/subgrupos",method=RequestMethod.GET)
	public Iterable<Subgrupo>getSubgrupoByGrupo(@PathVariable int grupo_id){
		return subgrupoRepository.findAll();
	}
	
	
	
	
	
	
	
	@RequestMapping(value="/subgrupos",method=RequestMethod.POST)
    public ResponseEntity<?> save(@RequestBody Subgrupo subgrupo){
		subgrupoRepository.save(subgrupo);
    	return new ResponseEntity<>(HttpStatus.CREATED);
	
}

	
	/*@RequestMapping(value="/subgrupos",method=RequestMethod.GET)
	public ResponseEntity<?> findAll(){
		Iterable<Subgrupo> subgrupo= subgrupoRepository.findAll();
		return new ResponseEntity<>(subgrupo,HttpStatus.OK);
		
	}*/
	
	@RequestMapping(value="//subgrupos/{subgrupo_id}",method=RequestMethod.GET)
	public ResponseEntity<?> findOne(@PathVariable int subgrupo_id){
		Iterable<Subgrupo> subgrupo= subgrupoRepository.findAll();
		return new ResponseEntity<>(subgrupo,HttpStatus.OK);
		
	}
	@RequestMapping(value="/subgrupos/{subgrupo_id}",method=RequestMethod.DELETE)
	public ResponseEntity<?> deleteCliente(@PathVariable int subgrupo_id){
		subgrupoRepository.delete(subgrupo_id);
		return new ResponseEntity<>(HttpStatus.OK);
	}
	
	
	
}
