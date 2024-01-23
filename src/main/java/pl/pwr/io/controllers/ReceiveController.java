package pl.pwr.io.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.server.ResponseStatusException;
import pl.pwr.io.dto.DeliveryDTO;
import pl.pwr.io.dto.DeliveryDTOMapper;
import pl.pwr.io.err.InsufficientPermissionException;
import pl.pwr.io.err.PackageReceiveException;
import pl.pwr.io.model.*;
import pl.pwr.io.services.DeliveryService;

import java.util.List;

@RestController
public class ReceiveController {

    @Autowired
    private DeliveryService deliveryService;

    private final DeliveryDTOMapper deliveryDTOMapper = new DeliveryDTOMapper();

    public List<Delivery> getCurrentDeliveries(Long userId) {
        throw new UnsupportedOperationException();
    }

    public Delivery checkDeliveryStatus(Long deliveryId) {
        throw new UnsupportedOperationException();
    }

    public void receiveDelivery(Long deliveryId) {
        throw new UnsupportedOperationException();
    }

    @GetMapping("/delivery/accept")
    public DeliveryDTO acceptDelivery(@RequestParam Long deliveryId, @RequestParam Long userId) {
        try {
            return deliveryDTOMapper.apply(deliveryService.acceptDelivery(deliveryId, userId));
        } catch (InsufficientPermissionException e) {
            throw new ResponseStatusException(HttpStatus.UNAUTHORIZED, e.getMessage(), e);
        } catch (PackageReceiveException e) {
            throw new ResponseStatusException(HttpStatus.NOT_ACCEPTABLE, e.getMessage(), e);
        }
    }

}