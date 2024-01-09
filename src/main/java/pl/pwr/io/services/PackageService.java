package pl.pwr.io.services;

import org.springframework.stereotype.Service;
import pl.pwr.io.model.PackageDetails;

@Service
public class PackageService {
    public PackageDetails getDefaultPackage() {
        PackageDetails packageDetails = new PackageDetails();
        packageDetails.setWeigth(1.0);
        packageDetails.setVolume(1.0);
        packageDetails.setDim_x(1.0);
        packageDetails.setDim_y(1.0);
        packageDetails.setDim_z(1.0);
        return packageDetails;
    }
}
