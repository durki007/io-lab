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
import org.hibernate.annotations.CreationTimestamp;
import org.springframework.boot.context.properties.bind.DefaultValue;

@Entity
@org.hibernate.annotations.Proxy(lazy = false)
@Table(name = "Delivery")
public class Delivery implements Serializable {
    public Delivery() {
    }

    @Column(name = "ID", nullable = false)
    @Id
    @GeneratedValue(generator = "MODEL_DELIVERY_ID_GENERATOR")
    @org.hibernate.annotations.GenericGenerator(name = "MODEL_DELIVERY_ID_GENERATOR", strategy = "native")
    private Long ID;

    @ManyToOne(targetEntity = User.class)
    @org.hibernate.annotations.Cascade({org.hibernate.annotations.CascadeType.LOCK})
    @JoinColumns(value = {@JoinColumn(name = "SenderID", referencedColumnName = "Id", nullable = false)}, foreignKey = @ForeignKey(name = "FKDelivery602113"))
    private User sender;

    @ManyToOne(targetEntity = User.class)
    @org.hibernate.annotations.Cascade({org.hibernate.annotations.CascadeType.LOCK})
    @JoinColumns(value = {@JoinColumn(name = "ReceiverID", referencedColumnName = "Id", nullable = false)}, foreignKey = @ForeignKey(name = "FKDelivery474573"))
    private User receiver;

    @ManyToOne(targetEntity = Address.class)
    @org.hibernate.annotations.Cascade({org.hibernate.annotations.CascadeType.LOCK})
    @JoinColumns(value = {@JoinColumn(name = "StartAddress", referencedColumnName = "ID", nullable = false)}, foreignKey = @ForeignKey(name = "FKDelivery256436"))
    private Address startAddress;

    @ManyToOne(targetEntity = Address.class)
    @org.hibernate.annotations.Cascade({org.hibernate.annotations.CascadeType.LOCK})
    @JoinColumns(value = {@JoinColumn(name = "DestinationAddress", referencedColumnName = "ID", nullable = false)}, foreignKey = @ForeignKey(name = "FKDelivery480217"))
    private Address destinationAddress;

    @OneToOne(optional = false, targetEntity = PackageDetails.class)
    @org.hibernate.annotations.Cascade({org.hibernate.annotations.CascadeType.SAVE_UPDATE, org.hibernate.annotations.CascadeType.LOCK})
    @JoinColumns(value = {@JoinColumn(name = "PackageDetailsId", referencedColumnName = "ID", nullable = false)}, foreignKey = @ForeignKey(name = "FKDelivery397092"))
    private PackageDetails packageDetails;

    @Column(name = "Status", nullable = true, length = 10)
//	@org.hibernate.annotations.Type(type="model.DeliveryStatusUserType")
    @Enumerated(EnumType.ORDINAL)
    private DeliveryStatus status;

    public PaymentStatus getPaymentStatus() {
        return paymentStatus;
    }

    public void setPaymentStatus(PaymentStatus paymentStatus) {
        this.paymentStatus = paymentStatus;
    }

    @Column(name = "PaymentStatus", nullable = true, length = 10)
    @Enumerated(EnumType.ORDINAL)
    private PaymentStatus paymentStatus;

    @Column(name = "Description", nullable = true, length = 255)
    private String description;

    @Column(name = "CreatedAt", nullable = true)
    @CreationTimestamp
    private java.sql.Timestamp createdAt;

    @Column(name = "ReceivedByDroneAt", nullable = true)
    private java.sql.Timestamp receivedByDroneAt;

    @Column(name = "ReceivedByUserAt", nullable = true)
    private java.sql.Timestamp receivedByUserAt;

    @Column(name = "HasDeliveryAddressBeenChanged", nullable = true)
    private boolean hasDeliveryAddressBeenChanged;

    @Column(name = "DeliveryAddressChangedAt", nullable = true)
    private java.sql.Timestamp deliveryAddressChangedAt;

    @OneToOne(optional = false, targetEntity = Location.class)
    @org.hibernate.annotations.Cascade({org.hibernate.annotations.CascadeType.SAVE_UPDATE, org.hibernate.annotations.CascadeType.LOCK})
    @JoinColumns(value = {@JoinColumn(name = "CurrentLocationId", referencedColumnName = "ID", nullable = false)}, foreignKey = @ForeignKey(name = "FKDelivery59230"))
    private Location currentLocation;

    @OneToOne(optional = false, targetEntity = PaymentDetails.class)
    @org.hibernate.annotations.Cascade({org.hibernate.annotations.CascadeType.SAVE_UPDATE, org.hibernate.annotations.CascadeType.LOCK})
    @JoinColumns(value = {@JoinColumn(name = "PaymentDetailsId", referencedColumnName = "ID", nullable = false)}, foreignKey = @ForeignKey(name = "FKDelivery993015"))
    private PaymentDetails paymentDetails;

    @Column(name = "DroneId", nullable = true)
    private Long droneId;

    private void setID(long value) {
        setID(Long.valueOf(value));
    }

    private void setID(Long value) {
        this.ID = value;
    }

    public Long getID() {
        return ID;
    }

    public Long getORMID() {
        return getID();
    }

    public void setStatus(DeliveryStatus value) {
        this.status = value;
    }

    public DeliveryStatus getStatus() {
        return status;
    }

    public void setDescription(String value) {
        this.description = value;
    }

    public String getDescription() {
        return description;
    }

    public void setCreatedAt(java.sql.Timestamp value) {
        this.createdAt = value;
    }

    public java.sql.Timestamp getCreatedAt() {
        return createdAt;
    }

    public void setReceivedByDroneAt(java.sql.Timestamp value) {
        this.receivedByDroneAt = value;
    }

    public java.sql.Timestamp getReceivedByDroneAt() {
        return receivedByDroneAt;
    }

    public void setReceivedByUserAt(java.sql.Timestamp value) {
        this.receivedByUserAt = value;
    }

    public java.sql.Timestamp getReceivedByUserAt() {
        return receivedByUserAt;
    }

    public void setHasDeliveryAddressBeenChanged(boolean value) {
        this.hasDeliveryAddressBeenChanged = value;
    }

    public boolean getHasDeliveryAddressBeenChanged() {
        return hasDeliveryAddressBeenChanged;
    }

    public void setDeliveryAddressChangedAt(java.sql.Timestamp value) {
        this.deliveryAddressChangedAt = value;
    }

    public java.sql.Timestamp getDeliveryAddressChangedAt() {
        return deliveryAddressChangedAt;
    }

    public void setDroneId(long value) {
        setDroneId(Long.valueOf(value));
    }

    public void setDroneId(Long value) {
        this.droneId = value;
    }

    public Long getDroneId() {
        return droneId;
    }

    public void setPackageDetails(PackageDetails value) {
        this.packageDetails = value;
    }

    public PackageDetails getPackageDetails() {
        return packageDetails;
    }

    public void setSender(User value) {
        this.sender = value;
    }

    public User getSender() {
        return sender;
    }

    public void setReceiver(User value) {
        this.receiver = value;
    }

    public User getReceiver() {
        return receiver;
    }

    public void setStartAddress(Address value) {
        this.startAddress = value;
    }

    public Address getStartAddress() {
        return startAddress;
    }

    public void setDestinationAddress(Address value) {
        this.destinationAddress = value;
    }

    public Address getDestinationAddress() {
        return destinationAddress;
    }

    public void setCurrentLocation(Location value) {
        this.currentLocation = value;
    }

    public Location getCurrentLocation() {
        return currentLocation;
    }

    public void setPaymentDetails(PaymentDetails value) {
        this.paymentDetails = value;
    }

    public PaymentDetails getPaymentDetails() {
        return paymentDetails;
    }

    public String toString() {
        return String.valueOf(getID());
    }

}
