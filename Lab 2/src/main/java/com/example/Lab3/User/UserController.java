package com.example.Lab3.User;

import com.example.Lab3.User.dto.CreateUserDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping(path = "/api/v1/users")
public class UserController {
    @Autowired
    public UserService userService;

    public UserController(UserService userService){
        this.userService=userService;
    }

    // GET ALL USERS
    @GetMapping()
    public List<User> getUsers(){
        return this.userService.getUsers();
    }

    // FIND BY ID
    @GetMapping("/{id}")
    public Optional<User> getUserById(@PathVariable Integer id){
        return this.userService.getUserById(id);
    }

    // CREATE USER
    @PostMapping()
    public User createUser(@RequestBody CreateUserDto createUserDto){
        return this.userService.createUser(createUserDto);
    }

    // UPDATE USER
    @PutMapping("/{id}")
    public User updateUser(@PathVariable Integer id, @RequestBody CreateUserDto userDto){
        return this.userService.updateUser(id, userDto);
    }

    // DELETE USER
    @DeleteMapping("/{id}")
    public String deleteUser(@PathVariable Integer id){
        userService.deleteUser(id);
        return "User deleted successfully";
    }
}