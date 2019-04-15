package pl.softsystem.wyklad1.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import pl.softsystem.wyklad1.model.UserModel;
import pl.softsystem.wyklad1.service.UserService;

import java.util.List;

@RestController
@RequestMapping("/api/user")
public class UserController {

    @Autowired
    private UserService userService;

    @GetMapping("/")
    public List<UserModel> getUsers() {
        return userService.getAllUsers();
    }

    @GetMapping("/{id}")
    public UserModel getUserByIndex(@PathVariable Long id) {
        return userService.getOne(id);
    }

    @PostMapping("/")
    public UserModel insertNewUser(@RequestBody UserModel userModel) {
        return userService.insertNewUser(userModel);
    }

    @PutMapping("/{id}")
    public UserModel updateUser(@PathVariable Long id, @RequestBody UserModel userModel) {
        return userService.updateUserById(id, userModel);
    }

}
