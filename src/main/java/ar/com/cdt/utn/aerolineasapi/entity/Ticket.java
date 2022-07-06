package ar.com.cdt.utn.aerolineasapi.entity;

import java.util.Date;

import javax.persistence.*;

@Entity
@Table(name = "ticket")
public class Ticket {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	
	private int reservationId;
	
	private int flightId;
	
	private String fullName;
	
	private String dni;
	
	@Temporal(TemporalType.TIMESTAMP)
	private Date reservationDate;
	
	private Boolean payment;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

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

	public Date getReservationDate() {
		return reservationDate;
	}

	public void setReservationDate(Date reservationDate) {
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
		return "Ticket [id=" + id + ", reservationId=" + reservationId + ", flightId=" + flightId + ", fullName="
				+ fullName + ", dni=" + dni + ", reservationDate=" + reservationDate + ", payment=" + payment + "]";
	}
	
	
	

}
