package perifaDelivery.PerifaBuy.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import perifaDelivery.PerifaBuy.model.CategoriaFornecedor;


public interface CategoriaFornecedorRepository extends JpaRepository<CategoriaFornecedor, Integer> {
	public List<CategoriaFornecedor> findAllByNomeContainingIgnoreCase(String categoriaFornecedor);
}
