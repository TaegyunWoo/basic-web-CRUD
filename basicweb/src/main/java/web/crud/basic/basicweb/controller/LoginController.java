package web.crud.basic.basicweb.controller;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import web.crud.basic.basicweb.domain.User;
import web.crud.basic.basicweb.domain.UserMapper;
import web.crud.basic.basicweb.form.LoginForm;

/**
 * 로그인 관련 컨트롤러
 */

@Slf4j
@RequiredArgsConstructor
@Controller
public class LoginController {

    private final UserMapper userMapper;

    @GetMapping("/")
    public String viewLogin(@ModelAttribute("user") LoginForm form) {

        return "home";
    }

    @PostMapping("/")
    public String login(@Validated @ModelAttribute("user") LoginForm form,
                        BindingResult bindingResult) {

        User user;
        if (bindingResult.hasFieldErrors()) {
            return "home";
        }

        user = getLoginUser(form.getEmail(), form.getPassword());
        if (user == null) {
            bindingResult.reject("wrongLoginInfo", null, null);
        }

        if (bindingResult.hasErrors()) {
            return "home";
        }


        return "redirect:/board";
    }

    /**
     *
     * @param email 로그인을 시도하는 email
     * @param password 로그인을 시도하는 password
     * @return null 로그인 실패
     * @return user 로그인 성공한 user의 정보
     */
    private User getLoginUser(String email, String password) {
        User user = userMapper.getUserByEmailAndPassword(email, password);
        log.info("user: ", user);
        return user;
    }

}
