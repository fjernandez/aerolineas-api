package ar.com.cdt.utn.aerolineasapi.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import ar.com.cdt.utn.aerolineasapi.entity.Flights;

@Repository
public interface FlightsRepository extends JpaRepository<Flights, Integer> {
	
	List<Flights> findByflyState(String state);

}
