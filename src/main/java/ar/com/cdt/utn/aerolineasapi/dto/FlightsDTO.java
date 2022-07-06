package ar.com.cdt.utn.aerolineasapi.dto;


public class FlightsDTO {
	
	private String destinationAirport;
	private String originAirport;
	private String flyStateId;
	private String date;
	private int price;
	private int capacity;
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
		return flyStateId;
	}
	public void setFlyStateId(String flyStateId) {
		this.flyStateId = flyStateId;
	}
	public String getDate() {
		return date;
	}
	public void setDate(String date) {
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
	@Override
	public String toString() {
		return "FlightsDTO [destinationAirport=" + destinationAirport + ", originAirport=" + originAirport
				+ ", flyStateId=" + flyStateId + ", date=" + date + ", price=" + price + ", capacity=" + capacity + "]";
	}

}
