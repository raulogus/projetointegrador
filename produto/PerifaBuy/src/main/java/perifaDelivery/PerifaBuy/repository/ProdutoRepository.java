package perifaDelivery.PerifaBuy.repository;

import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import perifaDelivery.PerifaBuy.model.Produto;

@Repository
public interface ProdutoRepository extends JpaRepository<Produto, Integer> {
	public List<Produto> findAllByUsernameContainingIgnoreCase(String nome);
}




	