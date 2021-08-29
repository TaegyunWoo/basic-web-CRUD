package web.crud.basic.basicweb.controller;

import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import web.crud.basic.basicweb.form.LoginForm;

/**
 * 로그인 관련 컨트롤러
 */

@Controller
public class LoginController {

    @GetMapping("/")
    public String viewLogin(@ModelAttribute("user") LoginForm form) {

        return "home";
    }

    @PostMapping("/")
    public String login(@Validated @ModelAttribute("user") LoginForm form,
                        BindingResult bindingResult) {

        if (bindingResult.hasErrors()) {
            return "home";
        }


        return "redirect:/board";
    }

}
