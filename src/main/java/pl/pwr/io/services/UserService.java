package pl.pwr.io.services;

import org.springframework.stereotype.Service;
import pl.pwr.io.model.*;

import java.util.NoSuchElementException;

@Service
public class UserService {

    public UserService() {
    }

    public User getUser(Long userId) throws NoSuchElementException {
        throw new UnsupportedOperationException();
    }

}