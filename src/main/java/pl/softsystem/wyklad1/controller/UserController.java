package pl.softsystem.wyklad1.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.*;
import pl.softsystem.wyklad1.config.AuthorizeExpressions;
import pl.softsystem.wyklad1.controller.validators.UserValidator;
import pl.softsystem.wyklad1.model.UserModel;
import pl.softsystem.wyklad1.service.UserService;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/api/user")
public class UserController {

    @Autowired
    private UserService userService;

    @Autowired
    private UserValidator userValidator;

    @InitBinder("userModel")
    protected void banUserDtoValidator(WebDataBinder binder) {
        binder.addValidators(userValidator);
    }

    @GetMapping("/")
    @PreAuthorize(AuthorizeExpressions.ADMIN)
    public List<UserModel> getUsers() {
        return userService.getAllUsers();
    }

    @GetMapping("/{id}")
    public UserModel getUserByIndex(@PathVariable Long id) {
        return userService.getOne(id);
    }

    @PostMapping("/")
    @PreAuthorize(AuthorizeExpressions.ADMIN)
    public UserModel insertNewUser(@Valid @RequestBody UserModel userModel) {
        return userService.insertNewUser(userModel);
    }

    @PutMapping("/{id}")
    public UserModel updateUser(@PathVariable Long id, @Valid @RequestBody UserModel userModel) {
        return userService.updateUserById(id, userModel);
    }

}
