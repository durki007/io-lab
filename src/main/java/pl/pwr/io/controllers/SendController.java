package pl.pwr.io.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.server.ResponseStatusException;
import pl.pwr.io.dto.DeliveryDTO;
import pl.pwr.io.dto.DeliveryDTOMapper;
import pl.pwr.io.dto.PaymentDetailsDTO;
import pl.pwr.io.err.DeliveryImpossibleException;
import pl.pwr.io.err.InvalidAddressException;
import pl.pwr.io.model.*;
import pl.pwr.io.dto.DeliveryRequest;
import pl.pwr.io.services.DeliveryService;

@RestController
public class SendController {

    @Autowired
    private DeliveryService deliveryService;

    private final DeliveryDTOMapper deliveryDTOMapper = new DeliveryDTOMapper();

    /**
     * @param userId
     * @param request
     */
    @PutMapping("/delivery/request")
    public DeliveryDTO createSendRequest(@RequestParam Long userId, @RequestBody DeliveryRequest request, @RequestBody PaymentDetailsDTO paymentDetails) {
        try {
            return deliveryDTOMapper.apply(deliveryService.createDelivery(userId, request, paymentDetails));
        } catch (InvalidAddressException e) {
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, e.getMessage(), e);
        } catch (DeliveryImpossibleException e) {
            throw new ResponseStatusException(HttpStatus.NOT_ACCEPTABLE, e.getMessage(), e);
        }
    }

    /**
     * @param deliveryId
     */
    public Delivery checkDeliveryStatus(Long deliveryId) {
        throw new UnsupportedOperationException();
    }

    /**
     * @param deliveryId
     * @param newAddress
     */
    public Delivery changeDeliveryAddress(Long deliveryId, Address newAddress) {
        throw new UnsupportedOperationException();
    }

}