package pl.pwr.io.controllers;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RestController;
import pl.pwr.io.model.*;
import pl.pwr.io.services.DeliveryService;

import java.util.List;

@RestController
public class DeliveryController {

    private DeliveryService deliveryService;

    /**
     * @param userId
     */
    @GetMapping("/delivery/current")
    public List<Delivery> getCurrentDeliveries(@RequestHeader Long userId) {
        return deliveryService.getCurrentDeliveries(userId);
    }

    /**
     * @param deliveryId
     * @param status
     */
    public Delivery changeDeliveryStatus(Long deliveryId, DeliveryStatus status) {
        // TODO - implement DeliveryController.changeDeliveryStatus
        throw new UnsupportedOperationException();
    }

}