package ar.com.cdt.utn.aerolineasapi.entity;

import javax.persistence.*;

import ar.com.cdt.utn.aerolineasapi.utils.AeroRoles;

@Entity
public class Role {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	
	@Enumerated(EnumType.STRING)
	private AeroRoles roles;
	
	public Role() {
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public AeroRoles getRoles() {
		return roles;
	}

	public void setRoles(AeroRoles roles) {
		this.roles = roles;
	}
	
	
}
