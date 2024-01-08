package pl.pwr.io.controllers;
import pl.pwr.io.model.*;
import pl.pwr.io.dto.DeliveryRequest;

public class SendController {

	/**
	 * 
	 * @param userId
	 * @param request
	 */
	public Delivery createSendRequest(Long userId, DeliveryRequest request) {
		throw new UnsupportedOperationException();
	}

	/**
	 * 
	 * @param deliveryId
	 */
	public Delivery checkDeliveryStatus(Long deliveryId) {
		throw new UnsupportedOperationException();
	}

	/**
	 * 
	 * @param deliveryId
	 * @param newAddress
	 */
	public Delivery changeDeliveryAddress(Long deliveryId, Address newAddress) {
		throw new UnsupportedOperationException();
	}

}