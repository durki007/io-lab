package pl.pwr.io.services;

import org.springframework.stereotype.Service;
import pl.pwr.io.model.*;
import pl.pwr.io.utils.AddressUtils;

@Service
public class DroneService {

    public DroneService() {
    }

    public boolean isDeliveryPossible(Delivery delivery) {
        var startAddress = delivery.getStartAddress();
        var destinationAddress = delivery.getDestinationAddress();

        // No address
        if (startAddress == null || destinationAddress == null) {
            return false;
        }
        // Invalid address
        if (!AddressUtils.isAddressValid(startAddress) || !AddressUtils.isAddressValid(destinationAddress)) {
            return false;
        }
        // Same address
        if (startAddress.equals(destinationAddress)) {
            return false;
        }
        // Different city
        if (!startAddress.getCity().equals(destinationAddress.getCity())) {
            return false;
        }
        // Different country
        if (!startAddress.getCountry().equals(destinationAddress.getCountry())) {
            return false;
        }

        // TODO: Check if drone can fly from startAddress to destinationAddress

        return true;
    }

    public int getDroneForDelivery(Delivery delivery) {
        return 1;
    }

    public boolean hasPackage(long droneId) {
        throw new UnsupportedOperationException();
    }
}