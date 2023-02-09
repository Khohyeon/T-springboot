package shop.mtcoding.blog2.controller;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class UserContoroller {
    @Autowired
    private HttpSession session;

    @GetMapping("/logout")
    public String logout() {
        // session.invalidate();
        return "redirect:/loginForm";
    }

    @GetMapping("/joinForm")
    public String joinForm() {
        return "/user/joinForm";
    }

    @GetMapping("/loginForm")
    public String loginForm() {
        return "/user/loginForm";
    }

    @GetMapping("user/updateForm")
    public String updateForm() {
        return "/user/updateForm";
    }

    @GetMapping("user/profileUpdate")
    public String profileupdate() {
        return "/user/profileUpdate";
    }
}
