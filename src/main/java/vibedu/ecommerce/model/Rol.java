package vibedu.ecommerce.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import vibedo.ecommerce.enums.RolName;
@Entity
public class Rol {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	@Enumerated(EnumType.STRING)
	@Column(unique = true)
	private RolName rolName;
	@Column(name = "status", nullable = false)
	private boolean status= true;

	public Rol() {
	}
	
	public Rol(RolName rolName) {
		super();
		this.rolName = rolName;
	}

	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	
	public RolName getRolName() {
		return rolName;
	}

	public void setRolName(RolName rolName) {
		this.rolName = rolName;
	}

	public boolean isStatus() {
		return status;
	}
	public void setStatus(boolean status) {
		this.status = status;
	}
	
}
