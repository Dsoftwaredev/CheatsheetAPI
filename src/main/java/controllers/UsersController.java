package controllers;

import entities.Cheatsheet;
import entities.Users;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Service
@RestController
public class UsersController {

    private final UsersService service;

    public UsersController(UsersService service) {
        this.service = service;
    }

    @GetMapping("/users")
    public List<Users> getAllUsers() {
        return this.service.getAllUsers();
    }

    @PostMapping("/users")
    public Users createUser(@RequestBody Users users) {
        return this.service.createUser(users);
    }

    @PutMapping("/users/{id}")
    @ResponseStatus(HttpStatus.OK)
    public Users updateUser(@PathVariable("id") Long id, @RequestBody Users users) {
        return this.service.updateUser(id, users);
    }
    @DeleteMapping("/users/{id}")
    public Users deleteUser(@PathVariable("id") Long id) {
        return this.service.deleteUser(id);
    }

}