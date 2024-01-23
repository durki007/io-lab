package pl.pwr.io.dto;

public record PackageDetailsDTO(
        int id,
        Double weight,
        Double x,
        Double y,
        Double z,
        Double volume
) {
}
