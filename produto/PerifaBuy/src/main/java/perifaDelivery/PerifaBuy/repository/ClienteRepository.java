package perifaDelivery.PerifaBuy.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import perifaDelivery.PerifaBuy.model.Cliente;

@Repository
public interface ClienteRepository extends JpaRepository<Cliente, Integer> {
	public List<Cliente> findAllByUsernameContainingIgnoreCase(String username);
}
