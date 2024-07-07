package br.betereli.memeland.cad_user.services;

import br.betereli.memeland.cad_user.entities.User;
import br.betereli.memeland.cad_user.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;
@Service
public class UserService {


    @Autowired
    private UserRepository userRepository;


    public User newUser(User user) {
        user.setRegistryDate(new Date());
        return userRepository.save(user);
    }

    public List<User> listAllUsers() {
        return userRepository.findAll();
    }


    public User findUserById(Long id) {
        return userRepository.findById(id).orElse(null);
    }
}
