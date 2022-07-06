package ar.com.cdt.utn.aerolineasapi.dto;

import java.util.List;

public class TokenResponseDTO {
	
	private String token;
	private String type = "Bearer";
	private String username;
	private List<String> roles;
	
	public TokenResponseDTO(String token, String type, List<String> roles) {
		super();
		this.token = token;
		this.username = username;
		this.roles = roles;
	}
	public String getToken() {
		return token;
	}
	public void setToken(String token) {
		this.token = token;
	}
	public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type = type;
	}
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public List<String> getRoles() {
		return roles;
	}
	public void setRoles(List<String> roles) {
		this.roles = roles;
	}
		
}