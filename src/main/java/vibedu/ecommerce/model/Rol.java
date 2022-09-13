package vibedu.ecommerce.model;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;

import net.bytebuddy.utility.nullability.NeverNull;
import vibedu.ecommerce.model.Usuario;

import vibedo.ecommerce.enums.RolName;
@Entity
public class Rol {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;
	@Enumerated(EnumType.STRING)
    @NeverNull
	@Column(unique = true)
	private RolName rolName;
	/*	@Column(name = "status", nullable = false)
	private boolean status= true;
	 @ManyToMany(mappedBy = "rol")
	    private List<Usuario> usuario;
*/
	 public Rol() {
	}
	
	public Rol(RolName rolName) {
		this.rolName = rolName;
	}

	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
	}
	
	public RolName getRolName() {
		return rolName;
	}

	public void setRolName(RolName rolName) {
		this.rolName = rolName;
	}

	
}
