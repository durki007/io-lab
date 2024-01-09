package pl.pwr.io.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pl.pwr.io.dao.DeliveryRepository;
import pl.pwr.io.err.DeliveryImpossibleException;
import pl.pwr.io.err.InvalidAddressException;
import pl.pwr.io.model.*;
import pl.pwr.io.dto.*;

import java.util.List;
import java.util.NoSuchElementException;

@Service
public class DeliveryService {

    private DroneService droneService;
    private UserService userService;
    private PaymentService paymentService;
    private AddressService addressService;

    private PackageService packageService;
    private DeliveryRepository deliveryRepository;

    @Autowired
    public DeliveryService(DroneService droneService, UserService userService, PaymentService paymentService, AddressService addressService, PackageService packageService, DeliveryRepository deliveryRepository) {
        this.droneService = droneService;
        this.userService = userService;
        this.paymentService = paymentService;
        this.addressService = addressService;
        this.packageService = packageService;
        this.deliveryRepository = deliveryRepository;
    }

    /**
     * @param userId
     * @param request
     * @param paymentDetails
     */
    public Delivery createDelivery(Long userId, DeliveryRequest request, PaymentDetailsDTO paymentDetails) throws NoSuchElementException, InvalidAddressException, DeliveryImpossibleException {
        Delivery delivery = new Delivery();
        delivery.setSender(userService.getUser(userId)); // Throws exception if user not found
        delivery.setReceiver(userService.getUser(request.receiverUserId())); // Throws exception if user not found
        // Check address validity
        delivery.setStartAddress(addressService.getOrCreateAddress(request.senderAddress())); // Throws exception if address invalid
        delivery.setDestinationAddress(addressService.getOrCreateAddress(request.receiverAddress())); // Throws exception if address invalid
        // Check if delivery is possible
        if (!droneService.isDeliveryPossible(delivery)) {
            throw new DeliveryImpossibleException();
        }
        // Initialize payment status
        delivery.setPaymentStatus(PaymentStatus.NONE);
        delivery.setPaymentDetails(paymentService.createPaymentDetails(paymentDetails));
        // Create first payment request
        paymentService.requestPayment(delivery.getSender(), delivery.getPaymentDetails());
        // Initialize delivery status
        delivery.setStatus(DeliveryStatus.PENDING);
        // Initialize package details
        delivery.setPackageDetails(packageService.getDefaultPackage());
        // Initialize drone
        delivery.setDroneId(droneService.getDroneForDelivery(delivery));

        // Save delivery
        return deliveryRepository.save(delivery);
    }

    /**
     * @param deliveryId
     */
    public Delivery getDeliveryStatus(Long deliveryId) {
        throw new UnsupportedOperationException();
    }

    /**
     * @param userId
     */
    public List<Delivery> getCurrentDeliveries(Long userId) {
        throw new UnsupportedOperationException();
    }

    /**
     * @param deliveryId
     * @param newAddress
     */
    public Delivery changeDeliveryAddress(Long deliveryId, Address newAddress) {
        throw new UnsupportedOperationException();
    }

    /**
     * @param deliveryId
     * @param newLocation
     */
    public void updateDeliveryLocation(Long deliveryId, Location newLocation) {
        throw new UnsupportedOperationException();
    }

    /**
     * @param deliveryId
     * @param newStatus
     */
    public void updateDeliveryStatus(Long deliveryId, DeliveryStatus newStatus) {
        throw new UnsupportedOperationException();
    }

}