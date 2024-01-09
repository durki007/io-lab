package pl.pwr.io.dto;

public record AddressDTO(
        String country,
        String city,
        String postalCode,
        String street,
        int houseNumber,
        int flatNumber
) {

}
