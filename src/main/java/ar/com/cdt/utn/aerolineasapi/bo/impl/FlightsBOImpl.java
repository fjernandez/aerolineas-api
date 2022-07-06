package ar.com.cdt.utn.aerolineasapi.bo.impl;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import org.modelmapper.ModelMapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import ar.com.cdt.utn.aerolineasapi.bo.FlightsBO;
import ar.com.cdt.utn.aerolineasapi.dto.FlightStatusDTO;
import ar.com.cdt.utn.aerolineasapi.dto.FlightsDTO;
import ar.com.cdt.utn.aerolineasapi.entity.Flights;
import ar.com.cdt.utn.aerolineasapi.exception.AirlineException;
import ar.com.cdt.utn.aerolineasapi.repository.FlightsRepository;

@Service
public class FlightsBOImpl implements FlightsBO {
	
	private final static Logger logger = LoggerFactory.getLogger(FlightsBOImpl.class);
	private final static String sourceDatePattern = "dd-MM-YYYY HH:mm:ss";
	private final static ModelMapper mapper = new ModelMapper();
	
	@Autowired
	FlightsRepository repository;

	@Override
	public List<Flights> getFlights() throws AirlineException {
		logger.info("Entra en getFlights");
		try {
			return repository.findAll();
		} catch (Exception e) {
			logger.error("Error - getFlights: {}", e.getMessage());
			throw new AirlineException("Hubo un error al traer la información de los vuelos: {}" + e.getMessage());
		}
	}

	@Override
	public FlightsDTO saveFlight(FlightsDTO flightsDTO) throws AirlineException {
		logger.info("Entra en saveFlights");
		try {
			Flights entity = new Flights();
			entity.setDestinationAirport(flightsDTO.getDestinationAirport());
			entity.setOriginAirport(flightsDTO.getOriginAirport());
			entity.setFlyStateId(flightsDTO.getFlyStateId());
			
			// Convierto fecha - String a util.Date
			DateFormat formatter = new SimpleDateFormat(sourceDatePattern);
			Date date = formatter.parse(flightsDTO.getDate());
			entity.setDate(date);
			entity.setPrice(flightsDTO.getPrice());
			entity.setCapacity(flightsDTO.getCapacity());
			repository.save(entity);
			FlightsDTO dto = mapper.map(entity, FlightsDTO.class);
			return dto;
		} catch (Exception e) {
			logger.error("Error - saveFlight: {}", e.getMessage());
			throw new AirlineException("Hubo un error al traer guardar el vuelo: {}" + e.getMessage());
		}
	}

	@Override
	public List<Flights> getFlightsByState(FlightsDTO flightDTO) {
		logger.info("Entra en getFlightsByState");
		return repository.findByflyState(flightDTO.getFlyStateId());
	}
	
	@Override
	public Flights updateFlightState(FlightStatusDTO flightStatusDTO) throws AirlineException {
		logger.info("Entra en updateFlightState");
		try {
			Flights flight = repository.getById(flightStatusDTO.getFlightId());
			flight.setFlyStateId(flightStatusDTO.getFlightStatus());
			return repository.save(flight);
		} catch (Exception e) {
			logger.error("Error - saveFlight: {}", e.getMessage());
			throw new AirlineException("Hubo un error actualizar el estado del vuelo: {}" + e.getMessage());
		}
		
	}

}
