package ar.com.cdt.utn.aerolineasapi.dto;

public class FlightStatusDTO {
	
	private int flightId;
	private String flightStatus;
	
	public int getFlightId() {
		return flightId;
	}
	public void setFlightId(int flightId) {
		this.flightId = flightId;
	}
	public String getFlightStatus() {
		return flightStatus;
	}
	public void setFlightStatus(String flightStatus) {
		this.flightStatus = flightStatus;
	}
	@Override
	public String toString() {
		return "FlightStatusDTO [flightId=" + flightId + ", flightStatus=" + flightStatus + "]";
	}
	
}
