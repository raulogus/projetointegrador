package perifaDelivery.PerifaBuy.seguranca;

import java.util.Optional;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Repository;

import perifaDelivery.PerifaBuy.model.Usuario;
import perifaDelivery.PerifaBuy.repository.UsuarioRepository;


@Repository
@Transactional //Leva o banco de dados de um estado consistente a outro
public class ImplementsUserDetailsService implements UserDetailsService{
	//UserDetailsService recupera os dados de um usuario dado seu username

	@Autowired
	private UsuarioRepository usuarioRepository;
	
	public UserDetails loadUserByNome(String login ) throws UsernameNotFoundException {
		Usuario usuario = usuarioRepository.findByNome(login);
		
		if(usuario == null){
			throw new UsernameNotFoundException("Usuario(a) não encontrado(a)!");
		}
		return new User(usuario.getEmail(), usuario.getPassword(), true, true, true, true, usuario.getAuthorities());
	}

	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		// TODO Auto-generated method stub
		return null;
	}

}