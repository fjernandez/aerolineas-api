package ar.com.cdt.utn.aerolineasapi.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import ar.com.cdt.utn.aerolineasapi.entity.Role;
import ar.com.cdt.utn.aerolineasapi.utils.AeroRoles;


public interface RoleRepository extends JpaRepository<Role, Long>{
	
	Role findByName(AeroRoles name);
}
