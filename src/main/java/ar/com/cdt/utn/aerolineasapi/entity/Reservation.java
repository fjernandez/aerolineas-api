package ar.com.cdt.utn.aerolineasapi.entity;

import java.util.Date;
import javax.persistence.*;


@Entity
@Table(name = "reservation")
public class Reservation {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	
	private String name;
	
	private String lastName;
	
	private String dni;
	 
	@Temporal(TemporalType.TIMESTAMP)
	private Date reservationDate;
	
	private Flights flights;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

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

	public Date getReservationDate() {
		return reservationDate;
	}

	public void setReservationDate(Date reservationDate) {
		this.reservationDate = reservationDate;
	}

	public Flights getFlights() {
		return flights;
	}

	public void setFlights(Flights flights) {
		this.flights = flights;
	}

	@Override
	public String toString() {
		return "Reservation [id=" + id + ", Name=" + name + ", lastName=" + lastName + ", dni=" + dni
				+ ", reservationDate=" + reservationDate + ", flights=" + flights + "]";
	}
}
