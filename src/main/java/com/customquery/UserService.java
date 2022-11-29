package com.customquery;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UserService {
    @Autowired
    UserRepository userRepository;

    public void save(User user) {
        userRepository.save(user);

    }

    public  User findByNameAndEmail(String name, String email) {

        return userRepository.findByNameAndEmail(name, email);

    }
    public List<User> listAllUser(){
        return userRepository.findAll();
    }
    public User findByName(String name){
        return userRepository.findByByName(name);
    }


}