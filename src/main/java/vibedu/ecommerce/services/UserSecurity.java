package vibedu.ecommerce.services;

import java.sql.Timestamp;
import java.util.Collection;
import java.util.List;
import java.util.stream.Collector;
import java.util.stream.Collectors;

import javax.persistence.Column;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import vibedu.ecommerce.model.Usuario;

public class UserSecurity implements UserDetails{
private long id;
private String username; 
private String password;
private String mail;
private String name;
private String last_name;
private int updated_by;
private boolean active;
private Timestamp created_at;
private Timestamp updated_at;
private Collection<? extends GrantedAuthority> authorities;


public UserSecurity(long id, String username, String password, 
		Collection<? extends GrantedAuthority> authorities) {
    this.id = id;
	this.username = username;
	this.password = password;
	
	this.authorities = authorities;
}
public static UserSecurity build(Usuario usuario) {
	List<GrantedAuthority> authorities =
			usuario.getRoles().stream().map(rol -> new SimpleGrantedAuthority(rol.getRolName().name())).collect(Collectors.toList());
	return new UserSecurity(usuario.getId(),usuario.getUsername(), usuario.getPassword(), authorities);
}
@Override
public Collection<? extends GrantedAuthority> getAuthorities() {
	// TODO Auto-generated method stub
	return authorities;
}
@Override
public String getPassword() {
	// TODO Auto-generated method stub
	return password;
}
@Override
public String getUsername() {
	// TODO Auto-generated method stub
	return username;
}
@Override
public boolean isAccountNonExpired() {
	// TODO Auto-generated method stub
	return true;
}
@Override
public boolean isAccountNonLocked() {
	// TODO Auto-generated method stub
	return true;
}
@Override
public boolean isCredentialsNonExpired() {
	// TODO Auto-generated method stub
	return true;
}
@Override
public boolean isEnabled() {
	// TODO Auto-generated method stub
	return true;
}
public long getId() {
	return id;
}
public void setId(int id) {
	this.id = id;
}

}
