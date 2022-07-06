package ar.com.cdt.utn.aerolineasapi.entity;

import java.util.Date;
import java.util.List;

import javax.persistence.*;

@Entity
@Table(name = "flights")
public class Flights {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	private String destinationAirport;
	private String originAirport;
	private String flyState;
	@Temporal(TemporalType.TIMESTAMP)
	private Date date;
	private int price;
	private int capacity;
	private List<Reservation> reservas;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getDestinationAirport() {
		return destinationAirport;
	}

	public void setDestinationAirport(String destinationAirport) {
		this.destinationAirport = destinationAirport;
	}

	public String getOriginAirport() {
		return originAirport;
	}

	public void setOriginAirport(String originAirport) {
		this.originAirport = originAirport;
	}

	public String getFlyStateId() {
		return flyState;
	}

	public void setFlyStateId(String flyStateId) {
		this.flyState = flyStateId;
	}

	public Date getDate() {
		return date;
	}

	public void setDate(Date date) {
		this.date = date;
	}

	public int getPrice() {
		return price;
	}

	public void setPrice(int price) {
		this.price = price;
	}

	public int getCapacity() {
		return capacity;
	}

	public void setCapacity(int capacity) {
		this.capacity = capacity;
	}

	public List<Reservation> getReservas() {
		return reservas;
	}

	public void setReservas(List<Reservation> reservas) {
		this.reservas = reservas;
	}

	@Override
	public String toString() {
		return "Flights [id=" + id + ", destinationAirport=" + destinationAirport + ", originAirport=" + originAirport
				+ ", flyStateId=" + flyState + ", date=" + date + ", price=" + price + ", capacity=" + capacity
				+ ", reservas=" + reservas + "]";
	}
}
