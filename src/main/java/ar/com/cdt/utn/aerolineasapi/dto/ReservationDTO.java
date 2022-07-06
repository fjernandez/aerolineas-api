package ar.com.cdt.utn.aerolineasapi.dto;

public class ReservationDTO {
	
	private String name;
	
	private String lastName;
	
	private String dni;
	
	private String reservationDate;
	
	private int flightId;

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public String getDni() {
		return dni;
	}

	public void setDni(String dni) {
		this.dni = dni;
	}

	public String getReservationDate() {
		return reservationDate;
	}

	public void setReservationDate(String reservationDate) {
		this.reservationDate = reservationDate;
	}

	public int getFlightId() {
		return flightId;
	}

	public void setFlightId(int flightId) {
		this.flightId = flightId;
	}

	@Override
	public String toString() {
		return "ReservationDTO [name=" + name + ", lastName=" + lastName + ", dni=" + dni + ", reservationDate="
				+ reservationDate + ", flightId=" + flightId + "]";
	}

}
