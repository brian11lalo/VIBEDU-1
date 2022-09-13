package vibedu.ecommerce.services;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import vibedu.ecommerce.repository.IUsuario;
@Service
@Transactional
public class UserService implements UserDetailsService {
	@Autowired
	private IUsuario Userrepository;
	public List<vibedu.ecommerce.model.Usuario> lista(){
		return Userrepository.findAll();
	}
	public Optional<vibedu.ecommerce.model.Usuario> getById(int id){
		return Userrepository.findById(id);
	}
	public Optional<vibedu.ecommerce.model.Usuario> getByUsername(String username){
		return Optional.ofNullable(Userrepository.findByUsername(username));
	}
	
	public void save(vibedu.ecommerce.model.Usuario usuario) {
		Userrepository.save(usuario);
	}
	public boolean existsById(int id) {
		return Userrepository.existsById(id);
	}
	public boolean existsByUsername(String Username) {
		return Userrepository.existsByUsername(Username);
	}
	
	
	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		vibedu.ecommerce.model.Usuario user=Userrepository.findByUsername(username);
		
		List<GrantedAuthority> roles = new ArrayList<>();
		roles.add(new SimpleGrantedAuthority("ADMIN"));
		//spring security user details
    	UserDetails userDet = new User(user.getUsername(), user.getPassword(),roles);

		// TODO Auto-generated method stub
		return userDet;
	}

}
