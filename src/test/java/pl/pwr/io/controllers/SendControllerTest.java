package pl.pwr.io.controllers;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import pl.pwr.io.dao.DeliveryRepository;
import pl.pwr.io.dto.AddressDTO;
import pl.pwr.io.dto.AddressDTOMapper;
import pl.pwr.io.dto.DeliveryRequest;
import pl.pwr.io.dto.PaymentDetailsDTO;
import pl.pwr.io.err.InvalidAddressException;
import pl.pwr.io.model.Address;
import pl.pwr.io.model.Delivery;
import pl.pwr.io.model.User;
import pl.pwr.io.services.AddressService;
import pl.pwr.io.services.PaymentService;
import pl.pwr.io.services.UserService;

import static org.mockito.AdditionalAnswers.returnsFirstArg;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.put;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@SpringBootTest
@AutoConfigureMockMvc
class SendControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private DeliveryRepository deliveryRepository;
    @MockBean
    private UserService userService;
    @MockBean
    private AddressService addressService;
    @MockBean
    private PaymentService paymentService;


    private Delivery delivery = new Delivery();
    private User userA = new User();
    private User userB = new User();
    private Address addressA = new Address();
    private Address addressB = new Address();
    private AddressDTO addressDTOA;
    private AddressDTO addressDTOB;
    private PaymentDetailsDTO paymentDetailsDTO;

    void mockUserService() {
        when(userService.getUser(1L)).thenReturn(userA);
        when(userService.getUser(2L)).thenReturn(userB);
    }

    void mockAddressService() throws InvalidAddressException {
        when(addressService.getOrCreateAddress(addressDTOA)).thenReturn(addressA);
        when(addressService.getOrCreateAddress(addressDTOB)).thenReturn(addressB);
    }

    void mockPaymentService() {
        when(paymentService.createPaymentDetails(any())).thenReturn(null);
        Mockito.doNothing().when(paymentService).requestPayment(any(), any());
    }

    void mockDeliveryRepository() {
        when(deliveryRepository.save(any())).then(returnsFirstArg());
//        when(deliveryRepository.save(any())).thenReturn(delivery);
    }

    void setupUsers() {
        userA.setUsername("userA");
        userB.setUsername("userB");
        userA.setEmail("a@a");
        userB.setEmail("b@b");
    }

    void setupAddressCorrect() {
        AddressDTOMapper mapper = new AddressDTOMapper();
        addressA.setCountry("Poland");
        addressA.setCity("Wrocław");
        addressA.setPostalCode("50-001");
        addressA.setStreet("ul. Główna");
        addressA.setHouseNumber(1);
        addressA.setFlatNumber(1);

        addressB.setCountry("Poland");
        addressB.setCity("Wrocław");
        addressB.setPostalCode("50-021");
        addressB.setStreet("ul. Grunwaldzka");
        addressB.setHouseNumber(1);
        addressB.setFlatNumber(1);

        addressDTOA = mapper.apply(addressA);
        addressDTOB = mapper.apply(addressB);
    }

    void setupAddressForImpossibleDelivery() {
        AddressDTOMapper mapper = new AddressDTOMapper();
        addressA.setCountry("Poland");
        addressA.setCity("Wrocław");
        addressA.setPostalCode("50-001");
        addressA.setStreet("ul. Główna");
        addressA.setHouseNumber(1);
        addressA.setFlatNumber(1);

        addressB.setCountry("Germany");
        addressB.setCity("Wrocław");
        addressB.setPostalCode("50-021");
        addressB.setStreet("ul. Grunwaldzka");
        addressB.setHouseNumber(1);
        addressB.setFlatNumber(1);

        addressDTOA = mapper.apply(addressA);
        addressDTOB = mapper.apply(addressB);
    }

    void setupDelivery() {
        delivery.setSender(userA);
        delivery.setReceiver(userB);
        delivery.setStartAddress(addressA);
        delivery.setDestinationAddress(addressB);
    }

    void setupPaymentDetails() {
        paymentDetailsDTO = new PaymentDetailsDTO(
                "1234567890123456",
                "123",
                "01/01",
                666
        );
    }

    void setupVariables() {
        setupPaymentDetails();
        setupUsers();
        setupDelivery();
    }

    void mockBeans() throws Exception {
        mockUserService();
        mockAddressService();
        mockPaymentService();
        mockDeliveryRepository();
    }

    void mock() throws Exception {
        setupVariables();
        mockBeans();
    }

    @Test
    void createSendRequest() throws Exception {
        setupAddressCorrect();
        mock();

        var RequestBody = new DeliveryRequest(
                1L,
                2L,
                addressDTOA,
                addressDTOB,
                paymentDetailsDTO
        );

        ObjectMapper objectMapper = new ObjectMapper();
        mockMvc.perform(put("/delivery/request")
                        .param("userId", "1")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(objectMapper.writeValueAsString(RequestBody))
                )
                .andDo(print())
                .andExpect(status().isOk());
    }

    @Test
    void createSendRequestImpossible() throws Exception {
        setupAddressForImpossibleDelivery();
        mock();

        var RequestBody = new DeliveryRequest(
                1L,
                2L,
                addressDTOA,
                addressDTOB,
                paymentDetailsDTO
        );

        ObjectMapper objectMapper = new ObjectMapper();
        mockMvc.perform(put("/delivery/request")
                        .param("userId", "1")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(objectMapper.writeValueAsString(RequestBody))
                )
                .andDo(print())
                .andExpect(status().isNotAcceptable());
    }
}