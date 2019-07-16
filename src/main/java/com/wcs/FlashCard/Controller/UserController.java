package com.wcs.FlashCard.Controller;

import com.wcs.FlashCard.Model.User;
import com.wcs.FlashCard.Repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
public class UserController {

    @Autowired
    private UserRepository userRepository;

    @GetMapping("/user/{userId}")
    public User read(@PathVariable Long userId) {
        return userRepository.findById(userId).get();
    }

    @PostMapping("/user")
    public User create(@RequestBody User user) {
        return userRepository.save(user);
    }

    @PutMapping("/user/{userId}")
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
}
