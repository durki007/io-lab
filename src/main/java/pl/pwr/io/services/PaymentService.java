package pl.pwr.io.services;

import org.springframework.stereotype.Service;
import pl.pwr.io.model.*;

@Service
public class PaymentService {

    public PaymentService() {
    }

    /**
     * @param user
     * @param value
     */
    public void requestPayment(User user, double value) {

    }

    /**
     * @param user
     */
    public PaymentStatus checkPaymentStatus(User user) {
        throw new UnsupportedOperationException();
    }

}