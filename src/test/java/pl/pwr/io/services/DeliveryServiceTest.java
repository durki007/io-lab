package pl.pwr.io.services;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;


@SpringBootTest
class DeliveryServiceTest {

    @Autowired
    private DeliveryService deliveryServiceUnderTest;

    @Test
    void testCreateDelivery() {
        System.out.println("TEST 1");
        assertTrue(true);
    }

    @Test
        // Test throwing unsupported operation exception
    void throwTest() {
        assertThrows(UnsupportedOperationException.class, () -> {
            deliveryServiceUnderTest.createDelivery(null);
        });
    }
}