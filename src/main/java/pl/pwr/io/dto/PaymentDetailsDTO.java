package pl.pwr.io.dto;

public record PaymentDetailsDTO(
        String value,
        String paymentMethod,
        String cardNumber,
        int CVC
) {
}
