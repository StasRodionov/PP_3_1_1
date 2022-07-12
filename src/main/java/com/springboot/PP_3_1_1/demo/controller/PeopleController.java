package com.springboot.PP_3_1_1.demo.controller;

import com.springboot.PP_3_1_1.demo.models.User;
import com.springboot.PP_3_1_1.demo.service.UserService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;


@Controller
@RequestMapping("/people")
public class PeopleController {

    private final UserService userService;

    public PeopleController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping()
    public String index (Model model) {
        model.addAttribute("people", userService.index());
        return "people/index";
    }

    @GetMapping("/{id}")
    public String show (@PathVariable("id") long id, Model model) {
        model.addAttribute("user", userService.showUser(id));
        return "people/show";
    }

    @GetMapping("/new")
    public String newUser (Model model) {
        model.addAttribute("user", new User());
        return "people/new";
    }

    @PostMapping()
    public String create (@ModelAttribute("user") User user) {
        userService.save(user);
        return "redirect:/people";
    }

    @GetMapping("/{id}/edit")
    public String edit (@PathVariable("id") long id, Model model) {
        model.addAttribute("user", userService.showUser(id));
        return "people/edit";
    }

    @PatchMapping("/{id}")
    public String update (@ModelAttribute("user") User user,
                          @PathVariable("id") long id) {
        userService.showUser(id);
        userService.update(user);
        return "redirect:/people";
    }

    @DeleteMapping("/{id}")
    public String deleteUser (@PathVariable("id") long id) {
        userService.deleteUser(id);
        return "redirect:/people";
    }
}
