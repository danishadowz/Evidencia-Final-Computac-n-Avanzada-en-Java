package com.example.evifinal;

import com.example.evifinal.model.User;
import com.example.evifinal.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Optional;

@Component
public class UserService {
    @Autowired
    private UserRepository userRepository;

    public User createuser(User user) {
        if (user.getEstatura() < 1 || user.getEstatura() > 2.5) {
            throw new IllegalArgumentException("La estatura debe estar entre 1m y 2.5m.");
        }

        if (user.getEdad() < 15) {
            throw new IllegalArgumentException("La edad debe ser igual o mayor a 15 años.");
        }
        return userRepository.save(user);

    }

    public User getUserById(Long Id) {
        Optional<User> optionalUser = userRepository.findById(Id);
        return optionalUser.get();

    }

    public List<User> getAllUsers() {
        return userRepository.findAll();

    }

    public void deleteUser(Long Id) {
        userRepository.deleteById(Id);

    }

    public List<User> getUsuario() {
        return null;
    }

}
