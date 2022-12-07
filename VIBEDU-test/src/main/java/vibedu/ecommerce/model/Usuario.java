package vibedu.ecommerce.model;

import java.sql.Time;
import java.sql.Timestamp;
import java.util.Date;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;

@Entity
public class Usuario {
	@Id //primary key
	@GeneratedValue(strategy= GenerationType.IDENTITY)
private long id;
	@Column(name="username",length =30)
private String username; 
	
	@Column(name="password",length =100)
private String password;
	
	@Column(name="mail",length =30)
private String mail;
	
	@Column(name="name",length =30)
private String name;
	
	@Column(name="last_name",length =30)
private String last_name;
	
	@Column(name="updated_by")
private int updated_by;
	
	@Column(name="active")
private boolean active;
	
	@Column(name="created_at")
private Timestamp created_at;
	
	@Column(name="updated_at")
private Timestamp updated_at;
	  @ManyToMany (fetch = FetchType.EAGER)
	    @JoinTable(name = "usuario_rol", joinColumns = @JoinColumn(name = "usuario_id"),
	            inverseJoinColumns = @JoinColumn(name = "rol_id"))
	    private Set<Rol> roles = new HashSet<>();
	


public Usuario(  String username, String password ) {
	
	this.username = username;
	this.password = password;
	
}


public Usuario() {
	// TODO Auto-generated constructor stub
}


public long  getId() {
	return id;
}
public void setId(long  id) {
	this.id = id;
}
public String getUsername() {
	return username;
}
public void setUsername(String username) {
	this.username = username;
}
public String getPassword() {
	return password;
}
public void setPassword(String password) {
	this.password = password;
}
public String getMail() {
	return mail;
}
public void setMail(String mail) {
	this.mail = mail;
}

public String getName() {
	return name;
}
public void setName(String name) {
	this.name = name;
}
public String getLast_name() {
	return last_name;
}
public void setLast_name(String last_name) {
	this.last_name = last_name;
}
public int getUpdated_by() {
	return updated_by;
}
public void setUpdated_by(int updated_by) {
	this.updated_by = updated_by;
}
public boolean isActive() {
	return active;
}
public void setActive(boolean active) {
	this.active = active;
}
public Timestamp getCreated_at() {
	return created_at;
}
public void setCreated_at(Timestamp created_at) {
	this.created_at = created_at;
}
public Timestamp getUpdated_at() {
	return updated_at;
}
public void setUpdated_at(Timestamp updated_at) {
	this.updated_at = updated_at;
}


public Set<Rol> getRoles() {
	return roles;
}


public void setRoles(Set<Rol> roles) {
	this.roles = roles;
}



}
