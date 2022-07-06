package ar.com.cdt.utn.aerolineasapi.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import ar.com.cdt.utn.aerolineasapi.bo.ReservationBO;
import ar.com.cdt.utn.aerolineasapi.dto.ReservationDTO;
import ar.com.cdt.utn.aerolineasapi.exception.AirlineException;

@RestController
@RequestMapping("api/aerolineas/reservation")
public class ReservationService {
	
	@Autowired
	ReservationBO reservationBO;
	
	@GetMapping("/getReservationsById")
	public ResponseEntity<?> getAllReservations(@RequestParam(name = "reservatoionId") String reservatoionId){
		Optional<?> entity = reservationBO.getReservations(Integer.valueOf(reservatoionId));
		return new ResponseEntity<>(entity, HttpStatus.OK);
	}
	
	@PostMapping("/saveReservation")
	public ResponseEntity<?> saveReservation(ReservationDTO reservationDTO) {
		ReservationDTO entity;
		try {
			entity = reservationBO.saveReservation(reservationDTO);
			return new ResponseEntity<>(entity, HttpStatus.OK);
		} catch (AirlineException e) {
			return new ResponseEntity<>(e.getMensaje(), HttpStatus.BAD_REQUEST);
		}
		
	}

}
