package ar.com.cdt.utn.aerolineasapi.security.services;

import java.util.Collection;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import ar.com.cdt.utn.aerolineasapi.entity.User;

public class UserDetailsImpl implements UserDetails {

	private static final long serialVersionUID = 1L;
	private int id;
	private String email;
	private String password;
	private Collection<? extends GrantedAuthority> authorities;
	
	

	public UserDetailsImpl(int i, String email, String password, Collection<? extends GrantedAuthority> authorities) {
		this.id = id;
		this.email = email;
		this.password = password;
		this.authorities = authorities;
	}
	
	public static UserDetailsImpl build(User user) {
		List<GrantedAuthority> authorities = user.getRoles()
				.stream()
				.map(role -> new SimpleGrantedAuthority(role.getRoles().name())).collect(Collectors.toList());
		return new UserDetailsImpl(user.getId(), user.getEmail(), user.getPassword(), authorities);
	}

	@Override
	public Collection<? extends GrantedAuthority> getAuthorities() {
		return authorities;
	}

	@Override
	public String getPassword() {
		return password;
	}

	@Override
	public String getUsername() {
		return email;
	}

	@Override
	public boolean isAccountNonExpired() {
		return true;
	}

	@Override
	public boolean isAccountNonLocked() {
		return true;
	}

	@Override
	public boolean isCredentialsNonExpired() {
		return true;
	}

	@Override
	public boolean isEnabled() {
		return true;
	}

	 Object getId() {
		// TODO Auto-generated method stub
		return null;
	}

}
