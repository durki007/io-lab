package pl.pwr.io.dto;

import pl.pwr.io.model.PackageDetails;

import java.util.function.Function;

public class PackageDetailsDTOMapper implements Function<PackageDetails, PackageDetailsDTO> {
    @Override
    public PackageDetailsDTO apply(PackageDetails packageDetails) {
        return new PackageDetailsDTO(
                packageDetails.getID(),
                packageDetails.getWeigth(),
                packageDetails.getDim_x(),
                packageDetails.getDim_y(),
                packageDetails.getDim_z(),
                packageDetails.getVolume()
        );
    }
}
