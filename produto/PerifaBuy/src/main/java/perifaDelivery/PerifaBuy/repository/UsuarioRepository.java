package perifaDelivery.PerifaBuy.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import perifaDelivery.PerifaBuy.model.Usuario;

public interface UsuarioRepository extends JpaRepository<Usuario,String>{
	public List<Usuario> findAllByNomeContainingIgnoreCase (String nome);
	public Optional<Usuario> findByNomeAndPassword(String nome, String password);
	public Usuario findByNome(String nome) {return Usuario};

}
//Metodo utilizado para a implementação do CRUD(cirar,ler,atualizar e deletar)

