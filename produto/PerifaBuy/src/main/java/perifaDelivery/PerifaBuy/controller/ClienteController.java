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

import perifaDelivery.PerifaBuy.model.Cliente;
import perifaDelivery.PerifaBuy.repository.ClienteRepository;

// pesquisar sobre o webMvcConfigurer
//import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@RestController
@RequestMapping("/cliente")
@CrossOrigin("*")
public class ClienteController {
	
	@Autowired
	private ClienteRepository repository;
		
	
	// ENDPOINTS -------------------------------------------------------------------------
	@GetMapping("/get/{id}")
	public ResponseEntity<Cliente> getById(@PathVariable Integer id) {
		return repository.findById(id).map(
				resp -> ResponseEntity.ok(resp))
				.orElse(ResponseEntity.notFound().build());
	}

	@GetMapping("/getAll")
	public ResponseEntity<List<Cliente>> getAll() {
		// pesquisar mais sobre responseEntity
		return ResponseEntity.ok(repository.findAll());
	}
	
	@PostMapping("/")
	public ResponseEntity<Cliente> post(@RequestBody Cliente cliente) {
		return ResponseEntity.status(HttpStatus.CREATED).body(repository.save(cliente));
	}
	
	
	@PutMapping("/atualizar")
	public ResponseEntity<Cliente> put(@RequestBody Cliente cliente) {
		return ResponseEntity.status(HttpStatus.OK).body(repository.save(cliente));
	}
	
	@DeleteMapping("/delete/{id}")
	public void delete(@PathVariable Integer id) {
		repository.deleteById(id);
	}
	
	
 }
