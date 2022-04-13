package com.codegym.controller;

import com.codegym.model.User;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@Controller
@SessionAttributes("user")
public class LoginController {

    @ModelAttribute("user")
    public User setUpFrom() {
        return new User();
    }

    @RequestMapping("/login")
    public String index(@CookieValue(value = "setUer", defaultValue = "") String setUser, Model model) {
        Cookie cookie = new Cookie("setUer", setUser);
        model.addAttribute("cookieValue", cookie);
        return "/login";
    }

    @PostMapping("/dologin")
    public String doLogin(@ModelAttribute("user") User user, Model model,
                          @CookieValue(value = "setUser", defaultValue = "") String setUser,
                          HttpServletResponse response, HttpServletRequest request) {
        if (user.getEmail().equals("admin@gmail.com") && user.getPassword().equals("12345")) {
            if (user.getEmail() != null) {
                setUser = user.getEmail();
            }
            Cookie cookie = new Cookie("setUser", setUser);
            cookie.setMaxAge(60*60);
            response.addCookie(cookie);

            Cookie[] cookies = request.getCookies();

            for (Cookie cookie1 : cookies) {
                if (cookie1.getName().equals("setUser")) {
                    model.addAttribute("cookieValue", cookie1);
                    break;
                } else {
                    cookie1.setValue("");
                    model.addAttribute("cookieValue", cookie1);
                    break;
                }
            }
            model.addAttribute("message", "Login success. Welcome");
        } else {
            user.setEmail("");
            Cookie cookie = new Cookie("setUser", setUser);
            model.addAttribute("cookieValue", cookie);
            model.addAttribute("message", "Login faild,Try again");
        }
        return "/login";
    }

}
