package ar.com.cdt.utn.aerolineasapi.dto;

import javax.validation.constraints.NotBlank;

public class LoginDTO {
	
	@NotBlank
	private String email;

	@NotBlank
	private String password;

	public String getUsername() {
		return email;
	}

	public void setUsername(String email) {
		this.email = email;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

}
