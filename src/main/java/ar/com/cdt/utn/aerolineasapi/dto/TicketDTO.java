package ar.com.cdt.utn.aerolineasapi.dto;

public class TicketDTO {
	
	private int reservationId;

	private int flightId;
	
	private String fullName;
	
	private String dni;
	
	private String reservationDate;
	
	private Boolean payment;

	public int getReservationId() {
		return reservationId;
	}

	public void setReservationId(int reservationId) {
		this.reservationId = reservationId;
	}

	public int getFlightId() {
		return flightId;
	}

	public void setFlightId(int flightId) {
		this.flightId = flightId;
	}

	public String getFullName() {
		return fullName;
	}

	public void setFullName(String fullName) {
		this.fullName = fullName;
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

	public Boolean getPayment() {
		return payment;
	}

	public void setPayment(Boolean payment) {
		this.payment = payment;
	}

	@Override
	public String toString() {
		return "TicketDTO [reservationId=" + reservationId + ", flightId=" + flightId + ", fullName=" + fullName
				+ ", dni=" + dni + ", reservationDate=" + reservationDate + ", payment=" + payment + "]";
	}
	
}
