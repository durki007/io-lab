package pl.pwr.io.services;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.TestPropertySource;
import pl.pwr.io.model.PackageDetails;

import static org.junit.jupiter.api.Assertions.*;
@SpringBootTest
class PackageServiceTest {

    @Autowired
    private PackageService packageServiceUnderTest;

    @Test
    void isPackageValid() {
        assertTrue(true);
    }

    @Test
    void positiveDimensionsVolumeTest(){
        double x = 10.0, y = 10.0, z = 10.0;
        double expectedVolume = x * y * z;

        PackageDetails packageDetails = packageServiceUnderTest.evaluatePackage(x, y, z);

        assertEquals(expectedVolume, packageDetails.getVolume());
    }

    @Test
    void positiveDimensionsWeightTest(){
        double x = 10.0, y = 10.0, z = 10.0;
        double expectedWeigth = (x * y * z) / 1000;

        PackageDetails packageDetails = packageServiceUnderTest.evaluatePackage(x, y, z);

        assertEquals(expectedWeigth, packageDetails.getWeigth());
    }

    @Test
    void negativeDimensionsTest(){
        double x = -10.0, y = -10.0, z = -10.0;

        assertThrows(IllegalArgumentException.class, () -> packageServiceUnderTest.evaluatePackage(x, y, z));
    }

    @Test
    void singleNegativeDimensionTest(){
        double x = -10.0, y = 10.0, z = 10.0;

        assertThrows(IllegalArgumentException.class, () -> packageServiceUnderTest.evaluatePackage(x, y, z));
    }

    @Test
    void zeroDimensionsTest(){
        double x = 0.0, y = 0.0, z = 0.0;

        assertThrows(IllegalArgumentException.class, () -> packageServiceUnderTest.evaluatePackage(x, y, z));
    }
    @Test
    void singleZeroDimensionTest(){
        double x = 0.0, y = 10.0, z = 10.0;

        assertThrows(IllegalArgumentException.class, () -> packageServiceUnderTest.evaluatePackage(x, y, z));
    }

    @Test
    void tooLargeDimensionsTest(){
        double x = 1000.0, y = 1000.0, z = 1000.0;

        assertThrows(IllegalArgumentException.class, () -> packageServiceUnderTest.evaluatePackage(x, y, z));
    }

    @Test
    void singleTooLargeDimensionTest(){
        double x = 1000.0, y = 10.0, z = 10.0;

        assertThrows(IllegalArgumentException.class, () -> packageServiceUnderTest.evaluatePackage(x, y, z));
    }

    @Test
    void nanDimensionsTest(){
        double x = Double.NaN, y = Double.NaN, z = Double.NaN;

        assertThrows(IllegalArgumentException.class, () -> packageServiceUnderTest.evaluatePackage(x, y, z));
    }
    @Test
    void singleNanDimensionTest(){
        double x = Double.NaN, y = 10.0, z = 10.0;

        assertThrows(IllegalArgumentException.class, () -> packageServiceUnderTest.evaluatePackage(x, y, z));
    }
}
