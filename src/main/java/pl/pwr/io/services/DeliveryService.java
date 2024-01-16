package pl.pwr.io.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pl.pwr.io.dao.DeliveryRepository;
import pl.pwr.io.err.DeliveryImpossibleException;
import pl.pwr.io.err.InsufficientPermissionException;
import pl.pwr.io.err.InvalidAddressException;
import pl.pwr.io.err.PackageReceiveException;
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

    public Delivery receiveDelivery(Long userId, Long deliveryId) {
        throw new UnsupportedOperationException();
    }

    public Delivery changeDeliveryAddress(Long deliveryId, AddressDTO newAddress) throws NoSuchElementException, InvalidAddressException {
        Delivery delivery = deliveryRepository.findById(deliveryId).orElseThrow();
        delivery.setDestinationAddress(addressService.getOrCreateAddress(newAddress));
        return deliveryRepository.save(delivery);
    }

    public Delivery getDeliveryStatus(Long deliveryId) {
        throw new UnsupportedOperationException();
    }

    public List<Delivery> getCurrentDeliveries(Long userId) {
        return deliveryRepository.findAllBySender_Id(userId);
    }

    public Delivery changeDeliveryAddress(Long deliveryId, Address newAddress) {
        throw new UnsupportedOperationException();
    }

    public void updateDeliveryLocation(Long deliveryId, Location newLocation) {
        throw new UnsupportedOperationException();
    }

    public void updateDeliveryStatus(Long deliveryId, DeliveryStatus newStatus) {
        throw new UnsupportedOperationException();
    }

    // Dostarczenie paczki do odbiorcy
    public Delivery acceptDelivery(Long deliveryId, Long userId) throws InsufficientPermissionException, PackageReceiveException {
        Delivery delivery;
        try {
            delivery = deliveryRepository.findById(deliveryId).orElseThrow();
        } catch (NoSuchElementException e) {
            throw new InsufficientPermissionException();
        }
        // Check if user is receiver
        if (!delivery.getReceiver().getId().equals(userId)) {
            throw new InsufficientPermissionException();
        }
        // Check if package has been removed from drone
        if (droneService.hasPackage(delivery.getDroneId())) {
            throw new PackageReceiveException();
        }
        delivery.setStatus(DeliveryStatus.ACCEPTED);
        return deliveryRepository.save(delivery);
    }

    // Funkcja wywoływana przez drona przy przejęciu paczki
    public void takeDelivery(Delivery delivery, long droneId) {
        delivery.setStatus(DeliveryStatus.IN_PROGRESS);
        deliveryRepository.save(delivery);
    }

    // Funkcja wywoływana przez drona przy błędzie podczas dostarczania paczki
    public void abortDelivery(Delivery delivery) {
        delivery.setStatus(DeliveryStatus.ABORTED);
        deliveryRepository.save(delivery);
    }

}