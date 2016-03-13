package homo.efficio.udemy.ecommerce.music.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.servlet.http.HttpServletRequest;

/**
 * Created by hanmomhanda on 16. 3. 13.
 */
@Controller
@RequestMapping("/cart")
public class CartItemController {

    @RequestMapping
    public String get(HttpServletRequest request) {
        return "redirect:/cart/" + request.getSession(true).getId();
    }

    @RequestMapping(value = "/{cartId}", method = RequestMethod.GET)
    public String getCart(@PathVariable(value = "cartId") Long cartId, Model model) {
        model.addAttribute("cartId", cartId);

        return "cart";
    }

}
