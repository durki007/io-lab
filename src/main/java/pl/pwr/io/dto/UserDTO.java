package pl.pwr.io.dto;

public record UserDTO(
        Long id,
        String username,
        String email
) {
}
