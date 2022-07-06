package ar.com.cdt.utn.aerolineasapi.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import ar.com.cdt.utn.aerolineasapi.entity.User;

@Repository
public interface UserRepository extends JpaRepository<User, Integer> {
	
	User findByEmail(String email);
	
	Boolean existsByEmail(String email);

}
