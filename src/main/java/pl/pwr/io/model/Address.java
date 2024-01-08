/**
 * "Visual Paradigm: DO NOT MODIFY THIS FILE!"
 * <p>
 * This is an automatic generated file. It will be regenerated every time
 * you generate persistence class.
 * <p>
 * Modifying its content may cause the program not work, or your work may lost.
 * <p>
 * Licensee: durki(Wrocław University of Science and Technology)
 * License Type: Academic
 */

/**
 * Licensee: durki(Wrocław University of Science and Technology)
 * License Type: Academic
 */
package pl.pwr.io.model;


import java.io.Serializable;

import jakarta.persistence.*;

@Entity
@org.hibernate.annotations.Proxy(lazy = false)
@Table(name = "Address")
public class Address implements Serializable {
    public Address() {
    }

    @Column(name = "ID", nullable = false, length = 10)
    @Id
    @GeneratedValue(generator = "MODEL_ADDRESS_ID_GENERATOR")
    @org.hibernate.annotations.GenericGenerator(name = "MODEL_ADDRESS_ID_GENERATOR", strategy = "native")
    private int ID;

    @Column(name = "Country", nullable = true, length = 255)
    private String country;

    @Column(name = "City", nullable = true, length = 255)
    private String city;

    @Column(name = "PostalCode", nullable = true, length = 255)
    private String postalCode;

    @Column(name = "Street", nullable = true, length = 255)
    private String street;

    @Column(name = "HouseNumber", nullable = false, length = 10)
    private int houseNumber;

    @Column(name = "FlatNumber", nullable = false, length = 10)
    private int flatNumber;

    @OneToMany(mappedBy = "startAddress", targetEntity = Delivery.class)
    @org.hibernate.annotations.Cascade({org.hibernate.annotations.CascadeType.SAVE_UPDATE, org.hibernate.annotations.CascadeType.LOCK})
    @org.hibernate.annotations.LazyCollection(org.hibernate.annotations.LazyCollectionOption.TRUE)
    private java.util.Set<Delivery> deliveryByStart = new java.util.HashSet();

    @OneToMany(mappedBy = "destinationAddress", targetEntity = Delivery.class)
    @org.hibernate.annotations.Cascade({org.hibernate.annotations.CascadeType.SAVE_UPDATE, org.hibernate.annotations.CascadeType.LOCK})
    @org.hibernate.annotations.LazyCollection(org.hibernate.annotations.LazyCollectionOption.TRUE)
    private java.util.Set<Delivery> deliveryByDestination = new java.util.HashSet();

    private void setID(int value) {
        this.ID = value;
    }

    public int getID() {
        return ID;
    }

    public int getORMID() {
        return getID();
    }

    public void setCountry(String value) {
        this.country = value;
    }

    public String getCountry() {
        return country;
    }

    public void setCity(String value) {
        this.city = value;
    }

    public String getCity() {
        return city;
    }

    public void setPostalCode(String value) {
        this.postalCode = value;
    }

    public String getPostalCode() {
        return postalCode;
    }

    public void setStreet(String value) {
        this.street = value;
    }

    public String getStreet() {
        return street;
    }

    public void setHouseNumber(int value) {
        this.houseNumber = value;
    }

    public int getHouseNumber() {
        return houseNumber;
    }

    public void setFlatNumber(int value) {
        this.flatNumber = value;
    }

    public int getFlatNumber() {
        return flatNumber;
    }

    public void setDeliveryByStart(java.util.Set value) {
        this.deliveryByStart = value;
    }

    public java.util.Set getDeliveryByStart() {
        return deliveryByStart;
    }


    public void setDeliveryByDestination(java.util.Set value) {
        this.deliveryByDestination = value;
    }

    public java.util.Set getDeliveryByDestination() {
        return deliveryByDestination;
    }


    public String toString() {
        return String.valueOf(getID());
    }

}
