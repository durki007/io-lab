package pl.pwr.io.dto;

import pl.pwr.io.model.Delivery;

import java.util.function.Function;

public class DeliveryRequestMapper implements Function<Delivery, DeliveryRequest> {

    @Override
    public DeliveryRequest apply(Delivery delivery) {
        AddressDTOMapper addressMapper = new AddressDTOMapper();
        PaymentDetailsDTOMapper paymentDetailsMapper = new PaymentDetailsDTOMapper();
        return new DeliveryRequest(
                delivery.getSender().getId(),
                delivery.getReceiver().getId(),
                addressMapper.apply(delivery.getStartAddress()),
                addressMapper.apply(delivery.getDestinationAddress()),
                paymentDetailsMapper.apply(delivery.getPaymentDetails())
        );
    }
}
