package ar.com.cdt.utn.aerolineasapi.bo;

import java.util.List;

import ar.com.cdt.utn.aerolineasapi.dto.FlightStatusDTO;
import ar.com.cdt.utn.aerolineasapi.dto.FlightsDTO;
import ar.com.cdt.utn.aerolineasapi.entity.Flights;
import ar.com.cdt.utn.aerolineasapi.exception.AirlineException;

public interface FlightsBO {
	
	List<Flights> getFlights() throws AirlineException;
	
	FlightsDTO saveFlight(FlightsDTO flightsDTO) throws AirlineException;
	
	List<Flights> getFlightsByState(FlightsDTO flightDTO); 
	
	Flights updateFlightState(FlightStatusDTO flightStatusDTO) throws AirlineException;
	

}
