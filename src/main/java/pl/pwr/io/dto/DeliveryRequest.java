package pl.pwr.io.dto;

import pl.pwr.io.model.*;


public record DeliveryRequest
        (
                Long senderUserId,
                Long receiverUserId,
                AddressDTO senderAddress,
                AddressDTO receiverAddress,

                PaymentDetailsDTO paymentDetails
        ) {
}
