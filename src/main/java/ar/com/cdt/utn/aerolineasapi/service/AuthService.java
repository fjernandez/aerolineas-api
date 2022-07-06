package ar.com.cdt.utn.aerolineasapi.service;

import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.*;

import ar.com.cdt.utn.aerolineasapi.dto.LoginDTO;
import ar.com.cdt.utn.aerolineasapi.dto.MessageResponseDTO;
import ar.com.cdt.utn.aerolineasapi.dto.SignUpDTO;
import ar.com.cdt.utn.aerolineasapi.dto.TokenResponseDTO;
import ar.com.cdt.utn.aerolineasapi.entity.Role;
import ar.com.cdt.utn.aerolineasapi.entity.User;
import ar.com.cdt.utn.aerolineasapi.repository.RoleRepository;
import ar.com.cdt.utn.aerolineasapi.repository.UserRepository;
import ar.com.cdt.utn.aerolineasapi.security.services.UserDetailsImpl;
import ar.com.cdt.utn.aerolineasapi.utils.AeroRoles;
import ar.com.cdt.utn.aerolineasapi.utils.TokenUtils;

@CrossOrigin(origins = "*", maxAge = 3600)
@RestController
@RequestMapping("/api/auth")
public class AuthService {
	
	@Autowired
	AuthenticationManager authenticationManager;

	@Autowired
	UserRepository userRepository;

	@Autowired
	RoleRepository roleRepository;

	@Autowired
	PasswordEncoder passwordEncoder;

	@Autowired
	TokenUtils tokenUtils;
	
	@PostMapping("/signin")
	public ResponseEntity<?> authenticateUser(@Valid @RequestBody LoginDTO loginDTO) {

		Authentication authentication = authenticationManager.authenticate(
				new UsernamePasswordAuthenticationToken(loginDTO.getUsername(), loginDTO.getPassword()));

		SecurityContextHolder.getContext().setAuthentication(authentication);
		String token = tokenUtils.generateToken(authentication);

		UserDetailsImpl userDetails = (UserDetailsImpl) authentication.getPrincipal();

		List<String> roles = userDetails.getAuthorities().stream().map(item -> item.getAuthority())
				.collect(Collectors.toList());

		return ResponseEntity.ok(
				new TokenResponseDTO(token, userDetails.getUsername(), roles));
	}
	
	@PostMapping("/signup")
	public ResponseEntity<?> registerUser(@Valid @RequestBody SignUpDTO signUpDTO) {

		if (userRepository.existsByEmail(signUpDTO.getEmail())) {
			return ResponseEntity.badRequest().body(new MessageResponseDTO("Error: Email is already taken!"));
		}


		// Create new user's account
		User user = new User(signUpDTO.getEmail(),
				passwordEncoder.encode(signUpDTO.getPassword()));

		Set<String> strRoles = signUpDTO.getRole();
		Set<Role> roles = new HashSet<>();

		if (strRoles == null) {
			Role userRole = roleRepository.findByName(AeroRoles.USER);
			roles.add(userRole);
		} else {
			strRoles.forEach(role -> {
				switch (role) {
				case "admin":
					Role adminRole = roleRepository.findByName(AeroRoles.ADMIN);
					roles.add(adminRole);
					break;
				case "mod":
					Role modRole = roleRepository.findByName(AeroRoles.MOD);
					roles.add(modRole);
					break;
				default:
					Role userRole = roleRepository.findByName(AeroRoles.USER);
					roles.add(userRole);
				}
			});
		}

		user.setRoles(roles);
		userRepository.save(user);

		return ResponseEntity.ok(new MessageResponseDTO("User registered successfully!"));
	}


}
