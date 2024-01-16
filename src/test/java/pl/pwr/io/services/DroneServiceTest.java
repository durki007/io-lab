package pl.pwr.io.services;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.TestPropertySource;
import pl.pwr.io.model.Address;
import pl.pwr.io.model.Delivery;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

@SpringBootTest
class DroneServiceTest {

    @Autowired
    private DroneService droneServiceUnderTest;

    @Test
    void nullAddressTest() {
        Address a = null;
        Address b = null;
        var delivery = new Delivery();
        delivery.setStartAddress(a);
        delivery.setDestinationAddress(b);
        assertFalse(droneServiceUnderTest.isDeliveryPossible(delivery));
    }

    @Test
    void validDelivery() {
        var a = new Address();
        var b = new Address();
        a.setCity("Wroclaw");
        b.setCity("Wroclaw");
        a.setCountry("Poland");
        b.setCountry("Poland");
        a.setPostalCode("50-001");
        b.setPostalCode("50-001");
        a.setStreet("Kazimierza Wielkiego");
        b.setStreet("Kosciuszki");
        a.setHouseNumber(10);
        b.setHouseNumber(10);
        var delivery = new Delivery();
        delivery.setStartAddress(a);
        delivery.setDestinationAddress(b);
        assertTrue(droneServiceUnderTest.isDeliveryPossible(delivery));
    }

    @Test
    void sameAddressDelivery() {
        var a = new Address();
        var b = new Address();
        a.setCity("Wroclaw");
        b.setCity("Wroclaw");
        a.setCountry("Poland");
        b.setCountry("Poland");
        a.setPostalCode("50-001");
        b.setPostalCode("50-001");
        a.setStreet("Kazimierza Wielkiego");
        b.setStreet("Kazimierza Wielkiego");
        a.setHouseNumber(10);
        b.setHouseNumber(10);
        a.setFlatNumber(1);
        b.setFlatNumber(1);
        var delivery = new Delivery();
        delivery.setStartAddress(a);
        delivery.setDestinationAddress(b);
        assertFalse(droneServiceUnderTest.isDeliveryPossible(delivery));
    }

    @Test
    void differentCityDelivery() {
        var a = new Address();
        var b = new Address();
        a.setCity("Wroclaw");
        b.setCity("Poznan");
        a.setCountry("Poland");
        b.setCountry("Poland");
        a.setPostalCode("50-001");
        b.setPostalCode("50-001");
        a.setStreet("Kazimierza Wielkiego");
        b.setStreet("Kosciuszki");
        a.setHouseNumber(10);
        b.setHouseNumber(10);
        var delivery = new Delivery();
        delivery.setStartAddress(a);
        delivery.setDestinationAddress(b);
        assertFalse(droneServiceUnderTest.isDeliveryPossible(delivery));
    }

    @Test
    void differentCountryDelivery() {
        var a = new Address();
        var b = new Address();
        a.setCity("Wroclaw");
        b.setCity("Wroclaw");
        a.setCountry("Poland");
        b.setCountry("Germany");
        a.setPostalCode("50-001");
        b.setPostalCode("50-001");
        a.setStreet("Kazimierza Wielkiego");
        b.setStreet("Kosciuszki");
        a.setHouseNumber(10);
        b.setHouseNumber(10);
        var delivery = new Delivery();
        delivery.setStartAddress(a);
        delivery.setDestinationAddress(b);
        assertFalse(droneServiceUnderTest.isDeliveryPossible(delivery));
    }
}
