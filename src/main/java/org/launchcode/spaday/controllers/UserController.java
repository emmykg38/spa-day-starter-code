package org.launchcode.spaday.controllers;

import org.launchcode.spaday.models.User;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@Controller
@RequestMapping("user")
public class UserController {

    @GetMapping("/add")
    public String displayAddUserForm(Model model) {
        model.addAttribute(new User());
        return "user/add";
    }

    @PostMapping
    public String processAddUserForm(Model model,
                                     @ModelAttribute @Valid User user, Errors errors) {

        model.addAttribute("errors", errors);

        String returnMsg = "";

        if (errors.hasErrors()) {
            returnMsg = "user/add";
        }

        if (user.getPassword().equals(user.getVerify())) {
            returnMsg = "user/index";
        }

        return returnMsg;

    }
}

//
//
//        if (user.getPassword().equals(user.getVerify())) {
//                return "user/index";
//                } else {
//                model.addAttribute("errors", "Passwords don't match!");
//                return "user/add";
//                }


