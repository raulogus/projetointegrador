package perifaDelivery.PerifaBuy.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import perifaDelivery.PerifaBuy.model.Cliente;
import perifaDelivery.PerifaBuy.model.Fornecedor;

public interface FornecedorRepository extends JpaRepository<Fornecedor, Integer> {
	public List<Fornecedor> findAllByNomeContainingIgnoreCase(String fornecedor);
}