package pl.pwr.io.dto;

import pl.pwr.io.model.PaymentDetails;

import java.util.function.Function;

public class PaymentDetailsDTOMapper implements Function<PaymentDetails, PaymentDetailsDTO> {

    @Override
    public PaymentDetailsDTO apply(PaymentDetails paymentDetailsDTO) {
        return new PaymentDetailsDTO(
                paymentDetailsDTO.getValue(),
                paymentDetailsDTO.getPaymentMethod(),
                paymentDetailsDTO.getCardNumber(),
                paymentDetailsDTO.getCVC()
        );
    }
}
