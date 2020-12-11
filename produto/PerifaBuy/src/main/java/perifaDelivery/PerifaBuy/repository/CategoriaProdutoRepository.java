package perifaDelivery.PerifaBuy.repository;

import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import perifaDelivery.PerifaBuy.model.CategoriaProdutoModel;

@Repository
public interface CategoriaProdutoRepository extends JpaRepository<CategoriaProdutoModel, Integer> {
	public List<CategoriaProdutoModel> findAllByNomeContainingIgnoreCase(String nome);
	public CategoriaProdutoModel findByNome(String nome);
}