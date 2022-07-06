package ar.com.cdt.utn.aerolineasapi.bo;

import java.util.List;
import java.util.Optional;

import ar.com.cdt.utn.aerolineasapi.dto.ReservationDTO;
import ar.com.cdt.utn.aerolineasapi.entity.Reservation;
import ar.com.cdt.utn.aerolineasapi.exception.AirlineException;

public interface ReservationBO {
	
	ReservationDTO saveReservation(ReservationDTO reservationDTO) throws AirlineException;

	Optional<Reservation> getReservations(int id);

}
