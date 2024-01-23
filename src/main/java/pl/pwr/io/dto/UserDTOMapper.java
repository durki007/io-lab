package pl.pwr.io.dto;

import pl.pwr.io.model.User;

import java.util.function.Function;

public class UserDTOMapper implements Function<User, UserDTO> {

    @Override
    public UserDTO apply(User user) {
        AddressDTOMapper addressMapper = new AddressDTOMapper();
        return new UserDTO(
                user.getId(),
                user.getUsername(),
                user.getEmail()
        );
    }

}
