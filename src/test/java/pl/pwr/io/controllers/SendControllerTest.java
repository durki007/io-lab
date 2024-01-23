package pl.pwr.io.controllers;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import pl.pwr.io.dao.DeliveryRepository;
import pl.pwr.io.dto.AddressDTO;
import pl.pwr.io.dto.DeliveryRequest;
import pl.pwr.io.dto.PaymentDetailsDTO;

import static org.junit.jupiter.api.Assertions.*;
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


    @Test
    void createSendRequest() throws Exception {
        var RequestBody = new DeliveryRequest(
                1L,
                2L,
                new AddressDTO(
                        "Poland",
                        "Wrocław",
                        "50-001",
                        "ul. Główna",
                        1,
                        1
                ),
                new AddressDTO(
                        "Poland",
                        "Wrocław",
                        "50-001",
                        "ul. Główna",
                        1,
                        1
                ),
                new PaymentDetailsDTO(
                        "1234567890123456",
                        "123",
                        "01/01",
                        666
                )
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
}