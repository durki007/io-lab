package pl.pwr.io.services;

import org.springframework.stereotype.Service;
import pl.pwr.io.model.*;

@Service
public class DroneService {

    public DroneService() {
    }

    /**
     * @param delivery
     */
    public boolean isDeliveryPossible(Delivery delivery) {
        throw new UnsupportedOperationException();
    }

    /**
     * @param delivery
     */
    public int getDroneForDelivery(Delivery delivery) {
        throw new UnsupportedOperationException();
    }

}