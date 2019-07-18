package com.wcs.FlashCard.Controller;

import com.wcs.FlashCard.Model.Authentication;
import com.wcs.FlashCard.Model.User;
import com.wcs.FlashCard.Repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class UserController {

    @Autowired
    private UserRepository userRepository;

    @GetMapping("/users/{userId}")
    public User read(@PathVariable Long userId) {
        return userRepository.findById(userId).get();
    }

    @GetMapping("/users")
    public List<User> read() {
        return userRepository.findAll();
    }

    @PostMapping("/users")
    public User create(@RequestBody User user) {
        return userRepository.save(user);
    }

    @PutMapping("/users/{userId}")
    public User update(@PathVariable Long userId, @RequestBody User user) {
        User userToUpdate = userRepository.findById(userId).get();
        if (user.getPassword() != null) {
            userToUpdate.setPassword(user.getPassword());
        }
        if (user.getMail() != null) {
            userToUpdate.setMail(user.getMail());
        }
        return userRepository.save(userToUpdate);
    }

    @PostMapping("/users/search")
    public Authentication search(@RequestBody User user) {
        Authentication authentication = new Authentication();
        User userFromDb = userRepository.findUserByMail(user.getMail());
        if (userFromDb == null) {
            authentication.setError("ERROR_EMAIL");
        } else if (!user.getPassword().equals(userFromDb.getPassword())) {
            authentication.setError("ERROR_PASSWORD");
        } else {
            authentication.setUser(userFromDb);
        }
        return authentication;
    }
}
