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
@Table(name="PaymentDetails")
public class PaymentDetails implements Serializable {
	public PaymentDetails() {
	}
	
	@Column(name="ID", nullable=false)	
	@Id	
	@GeneratedValue(generator="MODEL_PAYMENTDETAILS_ID_GENERATOR")	
	@org.hibernate.annotations.GenericGenerator(name="MODEL_PAYMENTDETAILS_ID_GENERATOR", strategy="native")	
	private int ID;
	
	@Column(name="UserId", nullable=true)
	private Long userId;

	public String getPaymentMethod() {
		return paymentMethod;
	}

	public void setPaymentMethod(String paymentMethod) {
		this.paymentMethod = paymentMethod;
	}

	public String getValue() {
		return value;
	}

	public void setValue(String value) {
		this.value = value;
	}

	@Column(name="PaymentMethod", nullable=true, length=255)
	private String paymentMethod;

	@Column(name="Value", nullable=true, length=255)
	private String value;
	
	@Column(name="PaymentAddress", nullable=true, length=10)	
	private Integer paymentAddress;
	
	@Column(name="CardNumber", nullable=true, length=255)	
	private String cardNumber;
	
	@Column(name="CVC", nullable=false, length=10)	
	private int CVC;
	
	@OneToOne(mappedBy="paymentDetails", targetEntity=Delivery.class)	
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
	
	public void setUserId(long value) {
		setUserId(Long.valueOf(value));
	}
	
	public void setUserId(Long value) {
		this.userId = value;
	}
	
	public Long getUserId() {
		return userId;
	}
	
	public void setPaymentAddress(int value) {
		setPaymentAddress(Integer.valueOf(value));
	}
	
	public void setPaymentAddress(Integer value) {
		this.paymentAddress = value;
	}
	
	public Integer getPaymentAddress() {
		return paymentAddress;
	}
	
	public void setCardNumber(String value) {
		this.cardNumber = value;
	}
	
	public String getCardNumber() {
		return cardNumber;
	}
	
	public void setCVC(int value) {
		this.CVC = value;
	}
	
	public int getCVC() {
		return CVC;
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
