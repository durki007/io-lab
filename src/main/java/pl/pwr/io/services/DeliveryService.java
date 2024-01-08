package pl.pwr.io.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pl.pwr.io.model.*;
import pl.pwr.io.dto.*;

import java.util.List;

@Service
public class DeliveryService {

    private DroneService droneService;
    private UserService userService;
    private PaymentService paymentService;

    @Autowired
    public DeliveryService(DroneService droneService, UserService userService, PaymentService paymentService) {
        this.droneService = droneService;
        this.userService = userService;
        this.paymentService = paymentService;
    }

    /**
     * @param request
     */
    public Delivery createDelivery(DeliveryRequest request) {
        throw new UnsupportedOperationException();
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