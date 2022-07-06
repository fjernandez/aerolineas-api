package ar.com.cdt.utn.aerolineasapi.service;


import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import ar.com.cdt.utn.aerolineasapi.bo.FlightsBO;
import ar.com.cdt.utn.aerolineasapi.dto.FlightStatusDTO;
import ar.com.cdt.utn.aerolineasapi.dto.FlightsDTO;
import ar.com.cdt.utn.aerolineasapi.entity.Flights;
import ar.com.cdt.utn.aerolineasapi.exception.AirlineException;

@RestController
@RequestMapping("/api/aerolineas/flights")
public class FlightsService {
		
	@Autowired
	FlightsBO flightsBO;
	
	@PostMapping("//save")
	public ResponseEntity<?> save(FlightsDTO flightsDTO){
		try {
			FlightsDTO entity = flightsBO.saveFlight(flightsDTO);
			return new ResponseEntity<>(entity, HttpStatus.OK);
		} catch (AirlineException e) {
			return new ResponseEntity<>(e.getMensaje(), HttpStatus.BAD_REQUEST);
		}
	}
	
	@PostMapping("/updateFlight")
	public ResponseEntity<?> updateFlightState(FlightStatusDTO flightStatusDTO){
		try {
			Flights entity = flightsBO.updateFlightState(flightStatusDTO);
			return new ResponseEntity<>(entity, HttpStatus.OK);
		} catch (AirlineException e) {
			return new ResponseEntity<>(e.getMensaje(), HttpStatus.BAD_REQUEST);
		}
	}
	
	@GetMapping("/getFlights")
	public ResponseEntity<?> getFlights(){
		try {
			List<Flights> entity = flightsBO.getFlights();
			return new ResponseEntity<>(entity, HttpStatus.OK);
		} catch (AirlineException e) {
			return new ResponseEntity<>(e.getMensaje(), HttpStatus.BAD_REQUEST);
		}
	}
	
	@PostMapping("/getFlightsByState")
	public ResponseEntity<?> getFlightsByState(FlightsDTO flight){
		List<Flights> entity = flightsBO.getFlightsByState(flight);
		return new ResponseEntity<>(entity, HttpStatus.OK);
	}

}
