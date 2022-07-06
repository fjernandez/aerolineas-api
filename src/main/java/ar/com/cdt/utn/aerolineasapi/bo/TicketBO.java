package ar.com.cdt.utn.aerolineasapi.bo;

import ar.com.cdt.utn.aerolineasapi.dto.TicketDTO;
import ar.com.cdt.utn.aerolineasapi.entity.Ticket;
import ar.com.cdt.utn.aerolineasapi.exception.AirlineException;

public interface TicketBO {
	
	TicketDTO save(int id, Boolean payment) throws AirlineException;

}
