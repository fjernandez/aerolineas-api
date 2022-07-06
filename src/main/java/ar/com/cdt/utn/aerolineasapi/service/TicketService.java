package ar.com.cdt.utn.aerolineasapi.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import ar.com.cdt.utn.aerolineasapi.bo.TicketBO;
import ar.com.cdt.utn.aerolineasapi.dto.TicketDTO;
import ar.com.cdt.utn.aerolineasapi.exception.AirlineException;

@RestController
@RequestMapping("/api/aerolineas/ticket")
public class TicketService {
	
	@Autowired
	TicketBO ticketBO;
	
	@GetMapping("/save")
	public ResponseEntity<?> save(@RequestParam(name = "reservationId") int id, @RequestParam(name = "payment") String payment) {
		try {
			Boolean pymt = Boolean.valueOf(payment);
			TicketDTO entity = ticketBO.save(id, pymt);
			return new ResponseEntity<>(entity, HttpStatus.OK);
		} catch (AirlineException e) {
			return new ResponseEntity<>(e.getMensaje(), HttpStatus.BAD_REQUEST);
		} catch (Exception e) {
			return new ResponseEntity<>(e.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}

}
