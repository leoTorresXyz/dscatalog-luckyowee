package com.luckyowee.dscatalog.resources;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
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
		/*
		 * Mock para testar inicialmente os endpoints enquanto nao tinha acesso ao Category Service
		List<Category> list = new ArrayList<>();
		list.add(new Category(1L, "Books"));
		list.add(new Category(2L, "Electronics"));
		list.add(new Category(3L, "Beverages"));
		*/
		List<CategoryDTO> list = service.findAll(); //retorna os dados e salva em list		
		return ResponseEntity.ok().body(list);
	}
	
}
