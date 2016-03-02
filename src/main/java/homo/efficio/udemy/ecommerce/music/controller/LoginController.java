package homo.efficio.udemy.ecommerce.music.controller;

import org.springframework.security.core.userdetails.User;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.http.HttpServletRequest;

/**
 * Created by hanmomhanda on 16. 3. 2.
 */
@Controller
public class LoginController {

    @RequestMapping("/login")
    public String login(@RequestParam(value="error", required = false) String error,
                        @RequestParam(value="logout", required = false) String logout,
                        Model model,
                        HttpServletRequest request) {

        if(error != null) {
            model.addAttribute("error", "Invalid username or password.");
        }

        if(logout != null) {
            model.addAttribute("msg", "You have been logged out successfully.");
        }

        model.addAttribute("loginUrl", request.getContextPath() + "/login");
        return "login";
    }
}
