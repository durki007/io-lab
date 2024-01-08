/**
 * "Visual Paradigm: DO NOT MODIFY THIS FILE!"
 * 
 * This is an automatic generated file. It will be regenerated every time 
 * you generate persistence class.
 * 
 * Modifying its content may cause the program not work, or your work may lost.
 */

/**
 * Licensee: durki(Wrocław University of Science and Technology)
 * License Type: Academic
 */
package pl.pwr.io.model;


import java.io.Serializable;
import jakarta.persistence.*;
@Entity
@org.hibernate.annotations.Proxy(lazy=false)
@Table(name="Location")
public class Location implements Serializable {
	public Location() {
	}
	
	@Column(name="ID", nullable=false, length=10)	
	@Id	
	@GeneratedValue(generator="MODEL_LOCATION_ID_GENERATOR")	
	@org.hibernate.annotations.GenericGenerator(name="MODEL_LOCATION_ID_GENERATOR", strategy="native")	
	private int ID;
	
	@Column(name="Latitude", nullable=false)	
	private double latitude;
	
	@Column(name="Longitude", nullable=false)	
	private double longitude;
	
	@Column(name="Timestamp", nullable=true)	
	private java.sql.Timestamp timestamp;
	
	@OneToOne(mappedBy="currentLocation", targetEntity=Delivery.class)	
	@org.hibernate.annotations.Cascade({org.hibernate.annotations.CascadeType.SAVE_UPDATE, org.hibernate.annotations.CascadeType.LOCK})	
	private Delivery delivery;
	
	private void setID(int value) {
		this.ID = value;
	}
	
	public int getID() {
		return ID;
	}
	
	public int getORMID() {
		return getID();
	}
	
	public void setLatitude(double value) {
		this.latitude = value;
	}
	
	public double getLatitude() {
		return latitude;
	}
	
	public void setLongitude(double value) {
		this.longitude = value;
	}
	
	public double getLongitude() {
		return longitude;
	}
	
	public void setTimestamp(java.sql.Timestamp value) {
		this.timestamp = value;
	}
	
	public java.sql.Timestamp getTimestamp() {
		return timestamp;
	}
	
	public void setDelivery(Delivery value) {
		this.delivery = value;
	}
	
	public Delivery getDelivery() {
		return delivery;
	}
	
	public String toString() {
		return String.valueOf(getID());
	}
	
}
