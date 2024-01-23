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

    @PutMapping("/delivery/request")
    public DeliveryDTO createSendRequest(@RequestParam Long userId, @RequestBody DeliveryRequest request) {
        try {
            return deliveryDTOMapper.apply(deliveryService.createDelivery(userId, request, request.paymentDetails()));
        } catch (InvalidAddressException e) {
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, e.getMessage(), e);
        } catch (DeliveryImpossibleException e) {
            throw new ResponseStatusException(HttpStatus.NOT_ACCEPTABLE, e.getMessage(), e);
        } catch (Exception e) {
            throw new ResponseStatusException(HttpStatus.INTERNAL_SERVER_ERROR, e.getMessage(), e);
        }
    }

    public Delivery checkDeliveryStatus(Long deliveryId) {
        throw new UnsupportedOperationException();
    }

    public Delivery changeDeliveryAddress(Long deliveryId, Address newAddress) {
        throw new UnsupportedOperationException();
    }

}