package pl.pwr.io.controllers;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.web.servlet.MockMvc;
import pl.pwr.io.dao.DeliveryRepository;
import pl.pwr.io.model.*;
import pl.pwr.io.services.DroneService;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.AdditionalAnswers.returnsFirstArg;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.anyLong;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@SpringBootTest
@AutoConfigureMockMvc
class ReceiveControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private DeliveryRepository deliveryRepository;
    @MockBean
    private DroneService droneService;


    Delivery getExampleDelivery() {
        Delivery delivery = new Delivery();
        delivery.setSender(getExampleUser());
        delivery.setReceiver(getExampleUser());
        delivery.setStartAddress(getExampleAddress());
        delivery.setDestinationAddress(getExampleAddress());
        delivery.setDroneId(1L);
        delivery.setStatus(DeliveryStatus.CREATED);
        delivery.setPackageDetails(getExamplePackageDetails());
        return delivery;
    }

    PackageDetails getExamplePackageDetails() {
        PackageDetails packageDetails = new PackageDetails();
        packageDetails.setID(1);
        packageDetails.setDim_x(1.0);
        packageDetails.setDim_y(1.0);
        packageDetails.setDim_z(1.0);
        packageDetails.setVolume(1.0);
        packageDetails.setWeigth(1.0);
        return packageDetails;
    }
    User getExampleUser() {
        User user = new User();
        user.setId(1L);
        user.setUsername("user");
        user.setEmail("useser@user");
        return user;
    }

    Address getExampleAddress() {
        Address address = new Address();
        address.setCountry("Poland");
        address.setCity("Wroclaw");
        address.setStreet("Wybrzeze Wyspianskiego");
        address.setHouseNumber(27);
        address.setFlatNumber(1);
        address.setPostalCode("50-370");
        return address;
    }

    void mockRepositoryBase() {
        when(deliveryRepository.save(any())).then(returnsFirstArg());
    }
    void mockRepositoryCorrect() {
        Delivery delivery = getExampleDelivery();
        delivery.getReceiver().setId(1L);
        when(deliveryRepository.findById(1L)).thenReturn(java.util.Optional.of(delivery));
    }

    void mockRepositoryInsufficientPermission1() {
        Delivery delivery = getExampleDelivery();
        delivery.getReceiver().setId(2L);
        when(deliveryRepository.findById(1L)).thenReturn(java.util.Optional.of(delivery));
    }

    void mockDroneServiceOk() {
        when(droneService.hasPackage(anyLong())).thenReturn(false);
    }

    void mockDroneServiceNotOk() {
        when(droneService.hasPackage(anyLong())).thenReturn(true);
    }

    void mockRepositoryInsufficientPermission2() {
        when(deliveryRepository.findById(1L)).thenReturn(java.util.Optional.empty());
    }

    @Test
    void acceptDelivery() throws Exception {
        mockRepositoryBase();
        mockRepositoryCorrect();
        mockDroneServiceOk();
        mockMvc.perform(get("/delivery/accept?deliveryId=1&userId=1"))
                .andDo(print())
                .andExpect(status().isOk());
    }

    @Test
    void acceptDeliveryInsufficientPermission1() throws Exception {
        mockRepositoryBase();
        mockRepositoryInsufficientPermission1();
        mockDroneServiceOk();
        mockMvc.perform(get("/delivery/accept?deliveryId=1&userId=1"))
                .andDo(print())
                .andExpect(status().isUnauthorized());
    }
    @Test
    void acceptDeliveryInsufficientPermission2() throws Exception {
        mockRepositoryBase();
        mockRepositoryInsufficientPermission2();
        mockDroneServiceOk();
        mockMvc.perform(get("/delivery/accept?deliveryId=1&userId=1"))
                .andDo(print())
                .andExpect(status().isUnauthorized());
    }

    @Test
    void acceptDeliveryPackageReceiveException() throws Exception {
        mockRepositoryBase();
        mockRepositoryCorrect();
        mockDroneServiceNotOk();
        mockMvc.perform(get("/delivery/accept?deliveryId=1&userId=1"))
                .andDo(print())
                .andExpect(status().isNotAcceptable());
    }
}