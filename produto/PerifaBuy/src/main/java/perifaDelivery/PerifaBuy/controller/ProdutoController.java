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

import perifaDelivery.PerifaBuy.model.Produto;
import perifaDelivery.PerifaBuy.repository.ProdutoRepository;

@RestController // controla toda a aplicação
@RequestMapping("/produto")// mapea toda a configuração
@CrossOrigin("*")//aceita qualquer tipo de api 

public class ProdutoController {
	
	@Autowired
	private ProdutoRepository repository;
	
	// ENDPOINTS -------------------------------------------------------------------------
	
	@GetMapping("/get/{id}")
	public ResponseEntity<Produto> getById(@PathVariable Integer id) {
		return repository.findById(id).map(
				resp -> ResponseEntity.ok(resp))
				.orElse(ResponseEntity.notFound().build());
	}

	@GetMapping("/getAll")
	public ResponseEntity<List<Produto>> getAll() {
		// pesquisar mais sobre responseEntity
		return ResponseEntity.ok(repository.findAll());
	}
	
	@PostMapping("/")
	public ResponseEntity<Produto> post(@RequestBody Produto produto) {
		return ResponseEntity.status(HttpStatus.CREATED).body(repository.save(produto));
	}

	// arrumar put, não funcionando ainda
		@PutMapping("/atualizar")
		public ResponseEntity<Produto> put(@RequestBody Produto produto) {
			return ResponseEntity.status(HttpStatus.OK).body(repository.save(produto));
		}
		
		@DeleteMapping("/delete/{id}")
		public void delete(@PathVariable Integer id) {
			repository.deleteById(id);
		}
		
}
