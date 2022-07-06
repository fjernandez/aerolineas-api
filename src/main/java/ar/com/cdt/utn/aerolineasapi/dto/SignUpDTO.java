package ar.com.cdt.utn.aerolineasapi.dto;

import java.util.Set;

public class SignUpDTO {
	
	private String email;
	
	private Set<String> role;
	
	private String password;
	
	public SignUpDTO(String email, Set<String> role, String password) {
		this.email = email;
		this.role = role;
		this.password = password;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public Set<String> getRole() {
		return role;
	}

	public void setRole(Set<String> role) {
		this.role = role;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}
	
	
}
