package hiber.controller;

import hiber.model.User;
import hiber.service.UserService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

@Controller
public class UserController {
    private final UserService userService;

    @Autowired
    public UserController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping
    public String index(ModelMap model) {
        return "redirect:/users";
    }

    @GetMapping(value = "/users")
    public String getUsers(ModelMap model) {
        model.addAttribute("usersList", userService.getUsers());
        return "users";
    }

    @GetMapping(value = "/add-user")
    public String newUser(ModelMap model) {
        model.addAttribute("user", new User());
        return "add-user";
    }

    @PostMapping(value = "/add-user")
    public String newUser(@ModelAttribute("user") @Valid User user, BindingResult result) {
        if (result.hasErrors()) {
            return "add-user";
        }
        userService.addUser(user);
        return "redirect:/users";
    }

    @GetMapping(value = "/edit-user")
    public String editUser(@RequestParam(value = "id") int id, ModelMap model){
        model.addAttribute("user", userService.getUser(id));
        return "edit-user";
    }

    @PostMapping(value = "/edit-user")
    public String editUser(@ModelAttribute("user") @Valid User user, BindingResult result) {
        if (result.hasErrors()) {
            return "edit-user";
        }
        userService.updateUser(user);
        return "redirect:/users";
    }

    @PostMapping(value = "/delete-user")
    public String deleteUser(@RequestParam(value = "id") int id) {
        userService.deleteUser(id);
        return "redirect:/users";
    }
}
