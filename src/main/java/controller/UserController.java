package controller;

import com.brigths.Final.Countdown.Project.model.User;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpSession;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import service.SessionService;
import service.UserService;

import java.util.List;

@Controller
public class UserController {
    @Autowired
    UserService userService;

    @Autowired
    SessionService sessionService;

    @GetMapping("/register")
    public String registerUser(Model model, HttpSession session){

        if (sessionService.loginCheck(session)) {
            return "redirect:/";
        }

        model.addAttribute("user", new User());

        return "user/register";
    }
    @PostMapping("/saveuser")
    public String saveUser(@Valid @ModelAttribute User user, BindingResult bindingResult, Model model){

        if(bindingResult.hasErrors()){
            return "/user/register";
        }

        User existingUser = userService.getUserByEmail(user.getEmail());

        if (existingUser != null) {
            model.addAttribute("exists", true);
            return "/user/register";
        }

        user.setPassword(new BCryptPasswordEncoder().encode(user.getPassword()));

        userService.saveUser(user);

        return "user/login";
    }
    @GetMapping("/login")
    public String loginForm(Model model, HttpSession session){

        if (sessionService.loginCheck(session)) {
            return "redirect:/";
        }

        model.addAttribute("error", false);

        return "user/login";

    }
    @PostMapping("/login")
    public String login(@RequestParam String email,
                        @RequestParam String password,
                        Model model,
                        HttpServletRequest request) {

        User user = userService.getUserByEmail(email);

        if (user == null) {
            System.out.println("wrong name");
            model.addAttribute("error", true);
            return "user/login";
        }

        if (new BCryptPasswordEncoder().matches(password, user.getPassword())) {
            request.getSession().setAttribute("user", user.getEmail());
            request.getSession().setAttribute("id", user.getId());
            request.getSession().setAttribute("firstName", user.getFirstName());
            request.getSession().setAttribute("lastName", user.getLastName());

            return "redirect:/";
        }
        model.addAttribute("error", true);
        return "user/login";

    }

}
