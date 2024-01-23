package pl.pwr.io.dto;

import pl.pwr.io.model.Delivery;

import java.util.function.Function;

public class DeliveryDTOMapper implements Function<Delivery, DeliveryDTO> {

    private final UserDTOMapper userMapper = new UserDTOMapper();
    private final AddressDTOMapper addressMapper = new AddressDTOMapper();
    private final PackageDetailsDTOMapper packageDetailsMapper = new PackageDetailsDTOMapper();

    @Override
    public DeliveryDTO apply(Delivery delivery) {
        return new DeliveryDTO(
                delivery.getID(),
                userMapper.apply(delivery.getSender()),
                userMapper.apply(delivery.getReceiver()),
                addressMapper.apply(delivery.getStartAddress()),
                addressMapper.apply(delivery.getDestinationAddress()),
                packageDetailsMapper.apply(delivery.getPackageDetails()),
                delivery.getStatus(),
                delivery.getPaymentStatus()
        );
    }
}
