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
@Table(name="PackageDetails")
public class PackageDetails implements Serializable {
	public PackageDetails() {
	}
	
	@Column(name="ID", nullable=false, length=10)	
	@Id	
	@GeneratedValue(generator="MODEL_PACKAGEDETAILS_ID_GENERATOR")	
	@org.hibernate.annotations.GenericGenerator(name="MODEL_PACKAGEDETAILS_ID_GENERATOR", strategy="native")	
	private int ID;
	
	@Column(name="Weigth", nullable=false)	
	private double weigth;
	
	@Column(name="Dim_x", nullable=false)	
	private double dim_x;
	
	@Column(name="Dim_y", nullable=false)	
	private double dim_y;
	
	@Column(name="Dim_z", nullable=false)	
	private double dim_z;
	
	@Column(name="Volume", nullable=false)	
	private double volume;
	
	@OneToOne(mappedBy="packageDetails", targetEntity=Delivery.class)	
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
	
	public void setWeigth(double value) {
		this.weigth = value;
	}
	
	public double getWeigth() {
		return weigth;
	}
	
	public void setDim_x(double value) {
		this.dim_x = value;
	}
	
	public double getDim_x() {
		return dim_x;
	}
	
	public void setDim_y(double value) {
		this.dim_y = value;
	}
	
	public double getDim_y() {
		return dim_y;
	}
	
	public void setDim_z(double value) {
		this.dim_z = value;
	}
	
	public double getDim_z() {
		return dim_z;
	}
	
	public void setVolume(double value) {
		this.volume = value;
	}
	
	public double getVolume() {
		return volume;
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
