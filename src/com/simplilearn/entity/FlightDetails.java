package com.simplilearn.entity;



import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="iam_FlightDetails")
public class FlightDetails {

	@Id
	@GeneratedValue
	@Column(name="iam_id")
	private int id;

	@Column(name="iam_source")
	private String source;
	
	@Column(name="iam_destination")
	private String destination;
	
	@Column(name="iam_airline")
	private String airline;
	
	@Column(name="iam_flight")
	private String flight;
	
	@Column(name="iam_price")
	private String price;
	
	@Column(name="iam_date")
	private String date;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getSource() {
		return source;
	}

	public void setSource(String source) {
		this.source = source;
	}

	public String getDestination() {
		return destination;
	}

	public void setDestination(String destination) {
		this.destination = destination;
	}

	public String getAirline() {
		return airline;
	}

	public void setAirline(String airline) {
		this.airline = airline;
	}

	public String getFlight() {
		return flight;
	}

	public void setFlight(String flight) {
		this.flight = flight;
	}

	public String getPrice() {
		return price;
	}

	public void setPrice(String price) {
		this.price = price;
	}

	public String getDate() {
		return date;
	}

	public void setDate(String date) {
		this.date = date;
	}


	
	
}
