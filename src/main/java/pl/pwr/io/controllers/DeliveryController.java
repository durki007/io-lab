package pl.pwr.io.controllers;

import org.springframework.web.bind.annotation.RestController;
import pl.pwr.io.model.*;

import java.util.List;

@RestController
public class DeliveryController {

	/**
	 * 
	 * @param userId
	 */
	public List<Delivery> getCurrentDeliveries(Long userId) {
		// TODO - implement DeliveryController.getCurrentDeliveries
		throw new UnsupportedOperationException();
	}

	/**
	 * 
	 * @param deliveryId
	 * @param status
	 */
	public Delivery changeDeliveryStatus(Long deliveryId, DeliveryStatus status) {
		// TODO - implement DeliveryController.changeDeliveryStatus
		throw new UnsupportedOperationException();
	}

}