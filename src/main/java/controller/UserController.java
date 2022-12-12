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
import org.springframework.web.bind.annotation.*;
import service.SessionService;
import service.UserService;

import java.util.List;

@Controller
public class UserController {
    @Autowired
    UserService userService;

    @Autowired
    SessionService sessionService;


    @GetMapping("/users")
    public String usersHome(Model model) {
        model.addAttribute("listOfUsers", userService.findAll());

        return "users";
    }
    @PostMapping("/saveUsers")
    public String saveUsers(@Valid @ModelAttribute User user,
                            BindingResult bindingResult, Model model,
                            @RequestParam(required = false) String email) {
        if (bindingResult.hasErrors()) {
            model.addAttribute("users", new User());
            return "users/new";
        }

        model.addAttribute("error", false);

        return "user/login";

    }

    @GetMapping("/showUserForUpdate/{id}")
    public String showUserForUpdate(@PathVariable(value = "id") long id, Model model,
                                    @RequestParam(required = false) String email) {


        User user = userService.findUserById(id);
        model.addAttribute("user",user);
        model.addAttribute("listOfUsers", userService.getUserByEmail(email));

        return "users/update";
    }
    @GetMapping("/showUserForDelete/{id}")
    public String showUserForDelete(@PathVariable(value = "id") long id) {
        userService.deleteUserById(id);
        return "redirect:/users";
    }
//    @GetMapping("/register")
//    public String registerUser(Model model, HttpSession session){
//
//        if (sessionService.loginCheck(session)) {
//            return "redirect:/";
//        }
//
//        model.addAttribute("user", new User());
//
//        return "user/register";
//    }
//    @PostMapping("/saveuser")
//    public String saveUser(@Valid @ModelAttribute User user, BindingResult bindingResult, Model model){
//
//        if(bindingResult.hasErrors()){
//            return "/user/register";
//        }
//
//        User existingUser = userService.getUserByEmail(user.getEmail());
//
//        if (existingUser != null) {
//            model.addAttribute("exists", true);
//            return "/user/register";
//        }
//
//        user.setPassword(new BCryptPasswordEncoder().encode(user.getPassword()));
//
//        userService.saveUser(user);
//
//        return "user/login";
//    }
//    @GetMapping("/login")
//    public String loginForm(Model model, HttpSession session){
//
//        if (sessionService.loginCheck(session)) {
//            return "redirect:/";
//        }
//
//        model.addAttribute("error", false);
//
//        return "user/login";
//
//    }
//    @PostMapping("/login")
//    public String login(@RequestParam String email,
//                        @RequestParam String password,
//                        Model model,
//                        HttpServletRequest request) {
//
//        User user = userService.getUserByEmail(email);
//
//        if (user == null) {
//            System.out.println("wrong name");
//            model.addAttribute("error", true);
//            return "user/login";
//        }
//
//        if (new BCryptPasswordEncoder().matches(password, user.getPassword())) {
//            request.getSession().setAttribute("user", user.getEmail());
//            request.getSession().setAttribute("id", user.getId());
//            request.getSession().setAttribute("firstName", user.getFirstName());
//            request.getSession().setAttribute("lastName", user.getLastName());
//
//            return "redirect:/";
//        }
//        model.addAttribute("error", true);
//        return "user/login";
//
//    }
//    @GetMapping("/users")
//    public String editRoles(Model model, HttpSession session) {
//
//        if (!sessionService.loginCheck(session)) {
//            return "redirect:/";
//        } else {
//            if (!session.getAttribute("role").equals("ADMIN")) {
//                return "redirect:/";
//            }
//        }
//
//        List<User> users = userService.getAllUsers();
//
//        model.addAttribute("users", users);
//        model.addAttribute("user", session.getAttribute("user"));
//
//        return "/user/editRoles";
//    }
//    @GetMapping("/user/showUpdateForm/{id}")
//    public String showFormForUpdate(@PathVariable(value = "id") long id, Model model, HttpSession session){
//
//        if (!sessionService.loginCheck(session)) {
//            return "redirect:/";
//        } else {
//            if (!session.getAttribute("role").equals("ADMIN")) {
//                return "redirect:/";
//            }
//        }
//        User updatedUser = userService.getUserById(id);
//        model.addAttribute("updateUser", updatedUser);
//        model.addAttribute("user", session.getAttribute("user"));
//
//        return "user/updateRole";
//
//
//    }
}
