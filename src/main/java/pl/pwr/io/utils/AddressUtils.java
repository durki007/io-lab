package pl.pwr.io.utils;

import pl.pwr.io.model.Address;

public class AddressUtils {

        public static boolean isAddressValid(Address address) {
            // Null check
            if (address.getCity() == null || address.getCountry() == null || address.getPostalCode() == null || address.getStreet() == null) {
                return false;
            }
            // Empty check
            if (address.getCity().isEmpty() || address.getCountry().isEmpty() || address.getPostalCode().isEmpty() || address.getStreet().isEmpty()) {
                return false;
            }
            // House number check
            if (address.getHouseNumber() < 1) {
                return false;
            }
            // Postal code check
            if (!address.getPostalCode().matches("\\d{2}-\\d{3}")) {
                return false;
            }
            return true;
        }

        public static boolean addressEquals(Address a, Address b) {
            if (a.getCity() != b.getCity()) {
                return false;
            }
            if (a.getCountry() != b.getCountry()) {
                return false;
            }
            if (a.getPostalCode() != b.getPostalCode()) {
                return false;
            }
            if (a.getStreet() != b.getStreet()) {
                return false;
            }
            if (a.getHouseNumber() != b.getHouseNumber()) {
                return false;
            }
            if (a.getFlatNumber() != b.getFlatNumber()) {
                return false;
            }
            return true;
        }
}
