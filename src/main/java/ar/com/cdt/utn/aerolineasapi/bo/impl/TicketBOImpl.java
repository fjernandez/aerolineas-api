package ar.com.cdt.utn.aerolineasapi.bo.impl;

import org.modelmapper.ModelMapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;

import ar.com.cdt.utn.aerolineasapi.bo.TicketBO;
import ar.com.cdt.utn.aerolineasapi.dto.TicketDTO;
import ar.com.cdt.utn.aerolineasapi.entity.Reservation;
import ar.com.cdt.utn.aerolineasapi.entity.Ticket;
import ar.com.cdt.utn.aerolineasapi.exception.AirlineException;
import ar.com.cdt.utn.aerolineasapi.repository.ReservationRepository;
import ar.com.cdt.utn.aerolineasapi.repository.TicketRepository;

public class TicketBOImpl implements TicketBO {
	
	private final static Logger logger = LoggerFactory.getLogger(TicketBOImpl.class);
	private final static ModelMapper mapper = new ModelMapper();
	
	@Autowired
	ReservationRepository reservationRepository;
	
	@Autowired
	TicketRepository ticketRepository;
	

	@Override
	public TicketDTO save(int id, Boolean payment) throws AirlineException {
		logger.info("Entra en save - TicketBOImpl");
		try {
			Reservation rsv =  reservationRepository.getById(id);
			
			Ticket ticket = new Ticket();
			
			ticket.setReservationId(rsv.getId());
			ticket.setFlightId(rsv.getFlights().getId());
			ticket.setFullName(rsv.getName() + " " + rsv.getLastName());
			ticket.setDni(rsv.getDni());
			ticket.setReservationDate(rsv.getReservationDate());
			ticket.setPayment(payment);

			Ticket entity = ticketRepository.save(ticket);
			TicketDTO dto = mapper.map(entity, TicketDTO.class);
			return dto;
		} catch (Exception e) {
			throw new AirlineException("Hubo un error al intentar Guardar el pasaje: {}" + e.getMessage());
		}
	}

}
