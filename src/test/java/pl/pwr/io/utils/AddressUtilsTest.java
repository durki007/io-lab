package pl.pwr.io.utils;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import pl.pwr.io.model.Address;
import pl.pwr.io.model.Delivery;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

@SpringBootTest
public class AddressUtilsTest {
    @Test
    void validAddress() {
        var a = new Address();
        a.setCity("Wroclaw");
        a.setCountry("Poland");
        a.setPostalCode("50-001");
        a.setStreet("Kazimierza Wielkiego");
        a.setHouseNumber(10);
        assertTrue(AddressUtils.isAddressValid(a));
    }
    @Test
    void emptyCity() {
        var a = new Address();
        a.setCity("");
        a.setCountry("Poland");
        a.setPostalCode("50-001");
        a.setStreet("Kazimierza Wielkiego");
        a.setHouseNumber(10);
        assertFalse(AddressUtils.isAddressValid(a));
    }
    @Test
    void invalidPostalCode() {
        var a = new Address();
        a.setCity("Wroclaw");
        a.setCountry("Poland");
        a.setPostalCode("58950-001");
        a.setStreet("Kazimierza Wielkiego");
        a.setHouseNumber(10);
        assertFalse(AddressUtils.isAddressValid(a));
    }
}
