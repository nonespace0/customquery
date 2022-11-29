package com.customquery;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class Controller {
    @Autowired
    UserService userService;
    @PostMapping("/save")
    public ResponseEntity<User> addData(@RequestBody  User user){
        userService.save(user);
        return ResponseEntity.ok(user);
    }
    @GetMapping("/find/{name}/{email}")
    public User getData(@PathVariable String name, @PathVariable String email, User user){
        user= userService.findByNameAndEmail(name, email);
        return user;

    }
    @GetMapping("/find/{name}")
    public User getByName(@PathVariable String name, User user){
        user= userService.findByName(name);
        return user;

    }
    @GetMapping("/findAll")
    public List<User> findAll(User user){
      return    userService.listAllUser();


    }

}
