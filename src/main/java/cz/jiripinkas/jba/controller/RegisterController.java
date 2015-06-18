package cz.jiripinkas.jba.controller;

import cz.jiripinkas.jba.entity.User;
import cz.jiripinkas.jba.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.validation.Valid;

/**
 * Created by omexic on 6/16/2015.
 */
@Controller
@RequestMapping("/register")
public class RegisterController {
    @Autowired
    UserService userService;

    @ModelAttribute("user")
    public User constructUser() {
        return new User();
    }

    @RequestMapping
    public String detail() {
        return "user-register";
    }

    @RequestMapping(method = RequestMethod.POST)
    public String doRegister(@Valid @ModelAttribute("user") User user, BindingResult result, RedirectAttributes redirectAttributes) {
        if (result.hasErrors()) {
            return "user-register";
        }
        userService.save(user);
        redirectAttributes.addFlashAttribute("success", true);
        return "redirect:/register.html";
    }

    @RequestMapping("/available")
    @ResponseBody
    public String available(@RequestParam String username) {
        Boolean booleanAvailable = userService.findOne(username) == null;
        return booleanAvailable.toString();
    }
}
