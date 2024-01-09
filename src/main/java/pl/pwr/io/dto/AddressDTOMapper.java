package pl.pwr.io.dto;

import pl.pwr.io.model.Address;

import java.util.function.Function;

public class AddressDTOMapper implements Function<Address, AddressDTO> {
    @Override
    public AddressDTO apply(Address address) {
        return new AddressDTO(
                address.getCountry(),
                address.getCity(),
                address.getPostalCode(),
                address.getStreet(),
                address.getHouseNumber(),
                address.getFlatNumber());
    }
}
