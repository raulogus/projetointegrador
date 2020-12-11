package perifaDelivery.PerifaBuy.controller;
import java.util.List;
import java.util.Optional;
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
import perifaDelivery.PerifaBuy.model.CategoriaProdutoModel;
import perifaDelivery.PerifaBuy.repository.CategoriaProdutoRepository;

@RestController
@RequestMapping("/pagina")
@CrossOrigin("*")
public class CategoriaProdutoController implements WebMvcConfigurer {
	public void addViewControllers(ViewControllerRegistry index) {
		index.addViewController("/").setViewName("forward:/index.html");
	}
	@Autowired
	private CategoriaProdutoRepository repository;
	//posts inserir-----------------------------------------------------------------------------------
		
	@PostMapping("/post")
	public ResponseEntity<CategoriaProdutoModel> post(@RequestBody CategoriaProdutoModel objeto)
	{
		return ResponseEntity.status(HttpStatus.CREATED).body(repository.save(objeto));
	}
	
	//get all select * from-----------------------------------------------------------------------------------
	
	@GetMapping("/getAll")
	public ResponseEntity<List<CategoriaProdutoModel>> GetAll()
	{
		return ResponseEntity.ok(repository.findAll());
	}
	//Updates-----------------------------------------------------------------------------------
	@PutMapping("put")
	public ResponseEntity<CategoriaProdutoModel> put (@RequestBody CategoriaProdutoModel nome)
	{
		return ResponseEntity.status(HttpStatus.OK).body(repository.save(nome));
	}
	
	//getbyid select where id-------------------------------------------------------------------------
	@GetMapping("/getById/{id}")
	public ResponseEntity<CategoriaProdutoModel> GetById(@PathVariable Integer id)
	{
		return repository.findById(id)
				.map(resp -> ResponseEntity.ok(resp))
				.orElse(ResponseEntity.notFound().build());
	}

	@GetMapping("/nome/{nome}")
	public ResponseEntity<List<CategoriaProdutoModel>> getByName(@PathVariable String nome){
		return ResponseEntity.ok(repository.findAllByNomeContainingIgnoreCase(nome));
	}	
	//delete --------------------------------------------------------------------------
	@DeleteMapping("/delete/{id}")
	public String remover(@PathVariable Integer id) {
		try {
			repository.deleteById(id);
			return "sucesso";
		}catch (Exception e) {
			return "Erro: " + e.getMessage();
		}
	}
}