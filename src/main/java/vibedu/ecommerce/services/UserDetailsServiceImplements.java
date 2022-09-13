package vibedu.ecommerce.services;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import vibedu.ecommerce.model.Usuario;
import vibedu.ecommerce.repository.IUsuario;

@Service
public class UserDetailsServiceImplements implements UserDetailsService {
	@Autowired
	UserService usuarioService;
	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		vibedu.ecommerce.model.Usuario user=usuarioService.getByUsername(username).orElseThrow(()-> new UsernameNotFoundException(username));
		
		return UserSecurity.build(user);
	}

}
