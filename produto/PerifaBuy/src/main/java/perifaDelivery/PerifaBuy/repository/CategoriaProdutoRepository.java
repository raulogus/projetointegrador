package perifaDelivery.PerifaBuy.repository;

import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import perifaDelivery.PerifaBuy.model.CategoriaProduto;

@Repository
public interface CategoriaProdutoRepository extends JpaRepository<CategoriaProduto, Integer> {
	public List<CategoriaProduto> findAllByNomeContainingIgnoreCase(String nome);
}