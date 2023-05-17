package peaksoft.api;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import peaksoft.entity.User;
import peaksoft.service.UserService;

import java.util.List;

@Controller
@RequestMapping("/users")
@RequiredArgsConstructor
public class UserApi {

    private final UserService service;

    @GetMapping
    public String getAllUsers(Model model) {
        model.addAttribute("users", service.getAllUsers());
        return "/getAllUsers";
    }

    @GetMapping("/new")
    public String createUser(Model model) {
        model.addAttribute("newUser", new User());
        return "/newUser";
    }

    @PostMapping("/saveUser")
    public String saveUser(@ModelAttribute("newUser") User user) {
        service.saveUser(user);
        return "redirect:/users";
    }

    @DeleteMapping("/{id}/delete")
    public String deleteUser(@PathVariable("id") Long id) {
        service.deleteUserById(id);
        return "redirect:/users";
    }

    @GetMapping("/edit/{id}")
    public String updateUser(Model model, @PathVariable Long id) {
        model.addAttribute("editUser", service.getUserById(id));
        return "updateUser";
    }

    @PutMapping("/saveUpdateUser/{id}")
    public String saveUpdateUser(@PathVariable("id") Long id,
                                 @ModelAttribute("editUser") User user) {
        service.updateUserById(id, user);
        return "redirect:/users";
    }

    @GetMapping("/search")
    public String searchUser(@RequestParam("word") String word, Model model) {
        List<User> users = service.searchUser(word);
        model.addAttribute("users", users);
        return "/searchResult"; // Return the name of the HTML template (searchResult.html)
    }



}
