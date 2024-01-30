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

    public PackageDetails evaluatePackage(double x, double y, double z) throws IllegalArgumentException {
        if (x <= 0 || y <= 0 || z <= 0) {
            throw new IllegalArgumentException("Dimensions must be positive");
        }
        if (x >= 1000 || y >= 1000 || z >= 1000) {
            throw new IllegalArgumentException("Dimensions are too large");
        }

        PackageDetails packageDetails = new PackageDetails();
        packageDetails.setVolume(x * y * z);
        packageDetails.setDim_x(x);
        packageDetails.setDim_y(y);
        packageDetails.setDim_z(z);
        packageDetails.setWeigth(packageDetails.getVolume() / 1000);
        return packageDetails;
    }
}
