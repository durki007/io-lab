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
@Table(name="`User`")
public class User implements Serializable {
	public User() {
	}
	
	@Column(name="Id", nullable=false)	
	@Id	
	@GeneratedValue(generator="MODEL_USER_ID_GENERATOR")	
	@org.hibernate.annotations.GenericGenerator(name="MODEL_USER_ID_GENERATOR", strategy="native")	
	private Long id;
	
	@Column(name="Username", nullable=true, length=255)	
	private String username;
	
	@Column(name="Email", nullable=true, length=255)	
	private String email;
	
	@Column(name="Password", nullable=true, length=255)	
	private String password;
	
	@Column(name="Role", nullable=true, length=10)	
	@Enumerated(EnumType.ORDINAL)
	private UserRole role;
	
	@OneToMany(mappedBy="sender", targetEntity=Delivery.class)	
	@org.hibernate.annotations.Cascade({org.hibernate.annotations.CascadeType.SAVE_UPDATE, org.hibernate.annotations.CascadeType.LOCK})	
	@org.hibernate.annotations.LazyCollection(org.hibernate.annotations.LazyCollectionOption.TRUE)	
	private java.util.Set deliveriesSent = new java.util.HashSet();
	
	@OneToMany(mappedBy="receiver", targetEntity=Delivery.class)	
	@org.hibernate.annotations.Cascade({org.hibernate.annotations.CascadeType.SAVE_UPDATE, org.hibernate.annotations.CascadeType.LOCK})	
	@org.hibernate.annotations.LazyCollection(org.hibernate.annotations.LazyCollectionOption.TRUE)	
	private java.util.Set deliveriesReceived = new java.util.HashSet();
	
	private void setId(long value) {
		setId(Long.valueOf(value));
	}
	
	private void setId(Long value) {
		this.id = value;
	}
	
	public Long getId() {
		return id;
	}
	
	public Long getORMID() {
		return getId();
	}
	
	public void setUsername(String value) {
		this.username = value;
	}
	
	public String getUsername() {
		return username;
	}
	
	public void setEmail(String value) {
		this.email = value;
	}
	
	public String getEmail() {
		return email;
	}
	
	public void setPassword(String value) {
		this.password = value;
	}
	
	public String getPassword() {
		return password;
	}
	
	public void setRole(UserRole value) {
		this.role = value;
	}
	
	public UserRole getRole() {
		return role;
	}
	
	public void setDeliveriesSent(java.util.Set value) {
		this.deliveriesSent = value;
	}
	
	public java.util.Set getDeliveriesSent() {
		return deliveriesSent;
	}
	
	
	public void setDeliveriesReceived(java.util.Set value) {
		this.deliveriesReceived = value;
	}
	
	public java.util.Set getDeliveriesReceived() {
		return deliveriesReceived;
	}
	
	
	public String toString() {
		return String.valueOf(getId());
	}
	
}
