package pl.softsystem.wyklad1.controller;

import org.springframework.web.bind.annotation.*;
import pl.softsystem.wyklad1.model.UserModel;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/api/user")
public class UserController {

    private static List<UserModel> users = new ArrayList<>();

    @GetMapping("/")
    public List<UserModel> getUsers() {
        return users;
    }

    @GetMapping("/{index}")
    public UserModel getUserByIndex(@PathVariable int index) {
        return users.get(index);
    }

    @PostMapping("/")
    public UserModel insertNewUser(@RequestBody UserModel userModel) {
        users.add(userModel);
        return userModel;
    }

    @PutMapping("/{index}")
    public UserModel updateUser(@PathVariable int index, @RequestBody UserModel userModel) {
        UserModel model = users.get(index);
        model.setLogin(userModel.getLogin());
        model.setName(userModel.getName());
        return model;
    }

}
