package pl.pwr.io.services;

import org.springframework.stereotype.Service;
import pl.pwr.io.dto.PaymentDetailsDTO;
import pl.pwr.io.model.*;

@Service
public class PaymentService {

    public PaymentService() {
    }

    /**
     * @param user
     * @param value
     */
    public void requestPayment(User user, PaymentDetails paymentDetails) {
        throw new UnsupportedOperationException();
    }

    public PaymentDetails createPaymentDetails(PaymentDetailsDTO paymentDetails) {
        throw new UnsupportedOperationException();
    }

    //
    public void rejectPaymentForDelivery(long deliveryId) {
        // Funkcja wywoływana przez dostawce usługi płatności w przypadku odrzucenia płatności
        throw new UnsupportedOperationException();
    }
    public void acceptPaymentForDelivery(long deliveryId) {
        // Funkcja wywoływana przez dostawce usługi płatności w przypadku akceptcji płatności
        throw new UnsupportedOperationException();
    }

    /**
     * @param user
     */
    public PaymentStatus checkPaymentStatus(User user) {
        throw new UnsupportedOperationException();
    }

}