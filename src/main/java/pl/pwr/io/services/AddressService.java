package pl.pwr.io.services;

import org.springframework.stereotype.Service;
import pl.pwr.io.dto.AddressDTO;
import pl.pwr.io.err.InvalidAddressException;
import pl.pwr.io.model.Address;

@Service
public class AddressService {
    public boolean isAddressValid(Address address) {
        throw new UnsupportedOperationException();
    }
    public boolean isAddressValid(AddressDTO address) throws InvalidAddressException {
        throw new UnsupportedOperationException();
    }

    public Address getOrCreateAddress(AddressDTO address) throws InvalidAddressException {
        throw new UnsupportedOperationException();
    }
}
