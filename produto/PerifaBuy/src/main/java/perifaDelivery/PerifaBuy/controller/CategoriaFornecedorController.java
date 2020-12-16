package perifaDelivery.PerifaBuy.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.config.annotation.ViewControllerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;


import perifaDelivery.PerifaBuy.model.CategoriaFornecedor;

import perifaDelivery.PerifaBuy.repository.CategoriaFornecedorRepository;


@RestController
@RequestMapping("/categoria_fornecedor") // ALTERAR ISSO PRA CLASSE DESEJADA
@CrossOrigin("*")
public class CategoriaFornecedorController implements WebMvcConfigurer {
	public void addViewControllers(ViewControllerRegistry index) {
		index.addViewController("/").setViewName("forward:/index.html");
	}
	
	@Autowired
	private CategoriaFornecedorRepository repository;
	
	@PostMapping("/post")
	public ResponseEntity<CategoriaFornecedor> post(@RequestBody CategoriaFornecedor objeto)
	{
		return ResponseEntity.status(HttpStatus.CREATED).body(repository.save(objeto));
	}
	
	@PutMapping("/put")
	public ResponseEntity<CategoriaFornecedor> put(@RequestBody CategoriaFornecedor objeto)
	{
		return ResponseEntity.status(HttpStatus.OK).body(repository.save(objeto));
	}
	
	@DeleteMapping("/delete/{id}")
	public void delete(@PathVariable Integer id) {
		repository.deleteById(id);
	}
	
	@GetMapping("/categoria_fornecedor/{id}")
	public ResponseEntity<CategoriaFornecedor> getById(@PathVariable Integer id) {
		return repository.findById(id).map(resp -> ResponseEntity.ok(resp))
				.orElse(ResponseEntity.notFound().build());
	}
	
	@GetMapping("/categoria_fornecedor")
	public ResponseEntity<List<CategoriaFornecedor>> GetAll()
	{
		return ResponseEntity.ok(repository.findAll());
	}
}
