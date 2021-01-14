package perifaDelivery.PerifaBuy.seguranca;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

import perifaDelivery.PerifaBuy.model.Cliente;
import perifaDelivery.PerifaBuy.model.Fornecedor;
import perifaDelivery.PerifaBuy.repository.ClienteRepository;
import perifaDelivery.PerifaBuy.repository.FornecedorRepository;

public class Service {
	
	@Autowired
	private ClienteRepository repository;

	public Cliente CadastrarCliente(Cliente cliente) {
		BCryptPasswordEncoder encoder = new BCryptPasswordEncoder();
		String senhaEncoder = encoder.encode(cliente.getPassword());
		cliente.setPassword(senhaEncoder);
		return repository.save(cliente);
	}
	
	@Autowired
	private FornecedorRepository repository2;

	public Fornecedor CadastrarFornecedor(Fornecedor Fornecedor) {
		BCryptPasswordEncoder encoder = new BCryptPasswordEncoder();
		String senhaEncoder = encoder.encode(Fornecedor.getSenha());
		Fornecedor.setSenha(senhaEncoder);
		return repository2.save(Fornecedor);
	}

}
