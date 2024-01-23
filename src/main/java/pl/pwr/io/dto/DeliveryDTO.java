package pl.pwr.io.dto;

import pl.pwr.io.model.DeliveryStatus;
import pl.pwr.io.model.PaymentStatus;

public record DeliveryDTO(
        Long id,
        UserDTO sender,
        UserDTO receiver,
        AddressDTO startAddress,
        AddressDTO destinationAddress,
        PackageDetailsDTO packageDetails,
        DeliveryStatus status,
        PaymentStatus paymentStatus
) {
}
