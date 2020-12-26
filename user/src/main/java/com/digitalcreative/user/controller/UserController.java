package com.digitalcreative.user.controller;

import com.digitalcreative.user.model.User;
import com.digitalcreative.user.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
public class UserController {

    @Autowired
    UserService userService;

    /**
     * Create - Add a new user
     * @param user An object user
     * @return The user object saved
     */
    @PostMapping("/user")
    public User createEmployee(@RequestBody User user) {
        return userService.saveUser(user);
    }

    /**
     * Read - Get one user
     * @param id The id of the user
     * @return An user object full filled
     */
    @GetMapping("/user/{id}")
    public User getUser(@PathVariable("id") final Long id) {
        Optional<User> user = userService.getUser(id);
        if(user.isPresent()) {
            return user.get();
        } else {
            return null;
        }
    }

    /**
     * Read - Get all users
     * @return - An Iterable object of user full filled
     */
    @GetMapping("/users")
    public Iterable<User> getUsers() {
        return userService.getUsers();
    }

    /**
     * Update - Update an existing user
     * @param id - The id of the user to update
     * @param user - The user object updated
     * @return
     */
    @PutMapping("/user/{id}")
    public User updateUser(@PathVariable("id") final Long id, @RequestBody User user) {
        Optional<User> e = userService.getUser(id);
        if(e.isPresent()) {
            User currentUser = e.get();

            String name = user.getName();
            if(name != null) {
                currentUser.setName(name);
            }
            String surname = user.getSurname();
            if(surname != null) {
                currentUser.setSurname(surname);;
            }
            String email = user.getEmail();
            if(email != null) {
                currentUser.setEmail(email);
            }
            String password = user.getPassword();
            if(password != null) {
                currentUser.setPassword(password);;
            }
            userService.saveUser(currentUser);
            return currentUser;
        } else {
            return null;
        }
    }

    /**
     * Delete - Delete an user
     * @param id - The id of the user to delete
     */
    @DeleteMapping("/user/{id}")
    public void deleteUser(@PathVariable("id") final Long id) {
        userService.deleteUser(id);
    }


}
