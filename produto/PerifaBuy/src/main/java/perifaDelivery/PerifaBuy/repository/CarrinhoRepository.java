package perifaDelivery.PerifaBuy.repository;

import java.util.Date;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import perifaDelivery.PerifaBuy.model.Carrinho;




public interface CarrinhoRepository extends JpaRepository<Carrinho, Integer> {
	
	public List<Carrinho> findAllByIdContaining(int id);
	
	public List<Carrinho> findAllByDataContaining(Date data);
	
}
