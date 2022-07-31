package com.luckyowee.dscatalog.resources;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.luckyowee.dscatalog.dto.CategoryDTO;
import com.luckyowee.dscatalog.services.CategoryService;

@RestController
@RequestMapping(value = "/categories") //este annotation define os endpoints da entidade category
public class CategoryResource {
	
	@Autowired
	private CategoryService service;
	
	@GetMapping
	public ResponseEntity<List <CategoryDTO>> findAll() {
		List<CategoryDTO> list = service.findAll(); //retorna todas categorias e salva em list		
		return ResponseEntity.ok().body(list);
	}
	
	@GetMapping(value = "/{id}") // concatena com o endpoint /categories => /categories/id
	public ResponseEntity<CategoryDTO> findById(@PathVariable Long id) {
		CategoryDTO dto = service.findById(id); //retorna a categoria com aquele id	 usando o metodo findById da camada de serviços
		return ResponseEntity.ok().body(dto);
	}
	
}
