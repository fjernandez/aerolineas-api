package ar.com.cdt.utn.aerolineasapi.bo.impl;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Optional;

import org.modelmapper.ModelMapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;

import ar.com.cdt.utn.aerolineasapi.bo.ReservationBO;
import ar.com.cdt.utn.aerolineasapi.dto.ReservationDTO;
import ar.com.cdt.utn.aerolineasapi.entity.Flights;
import ar.com.cdt.utn.aerolineasapi.entity.Reservation;
import ar.com.cdt.utn.aerolineasapi.exception.AirlineException;
import ar.com.cdt.utn.aerolineasapi.repository.FlightsRepository;
import ar.com.cdt.utn.aerolineasapi.repository.ReservationRepository;

public class ReservationBOImpl implements ReservationBO {
	
	private final static Logger logger = LoggerFactory.getLogger(ReservationBOImpl.class);
	private final static String sourceDatePattern = "dd-MM-YYYY HH:mm:ss";
	private final static ModelMapper mapper = new ModelMapper();
	
	@Autowired
	ReservationRepository reservationRepository;
	
	@Autowired
	FlightsRepository flightRepository;

	@Override
	public Optional<Reservation> getReservations(int id) {
		logger.info("Entra en findAllReservations");
		return reservationRepository.findById(id);
	}

	@Override
	public ReservationDTO saveReservation(ReservationDTO reservationDTO) throws AirlineException {
		logger.info("Entra en saveReservation");
		try {
			Reservation reservation = new Reservation();
			reservation.setName(reservationDTO.getName());
			reservation.setLastName(reservationDTO.getLastName());
			reservation.setDni(reservationDTO.getDni());
			
			DateFormat formatter = new SimpleDateFormat(sourceDatePattern);
			Date reservationDate = formatter.parse(reservationDTO.getReservationDate());
			reservation.setReservationDate(reservationDate);
			
			Flights flight = new Flights();
			flight.setId(reservationDTO.getFlightId());
			
			reservation.setFlights(flight);
			reservationRepository.save(reservation);
			
			ReservationDTO entity = mapper.map(reservation, ReservationDTO.class);
			return entity;
		} catch (Exception e) {
			throw new AirlineException("Ocurrio un error al guardar la reserva: {}" + e.getMessage());
		}
	}

}
