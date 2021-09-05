package web.crud.basic.basicweb.controller;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import web.crud.basic.basicweb.Service.BoardService;
import web.crud.basic.basicweb.domain.Article;
import web.crud.basic.basicweb.domain.User;
import web.crud.basic.basicweb.form.NewArticleForm;

import java.time.LocalDateTime;
import java.util.Collection;
import java.util.Collections;
import java.util.List;

@Slf4j
@RequiredArgsConstructor
@Controller
@RequestMapping("/board")
public class BoardController {

    private final BoardService boardService;

    @GetMapping
    public String showBoard(Model model) {
        List<Article> articleList = boardService.getAllArticles();
        Collections.reverse(articleList);
        model.addAttribute(articleList);
        return "board";
    }

    @GetMapping("/new-article")
    public String showArticleAddForm(@ModelAttribute("article") NewArticleForm form) {
        return "new-article";
    }

    @PostMapping("/new-article")
    public String addArticle(@Validated @ModelAttribute("article") NewArticleForm form,
                             @SessionAttribute("loginUser") User user,
                             BindingResult bindingResult) {
        if (bindingResult.hasErrors()) {
            return "new-article";
        }

        Article newArticle = new Article();
        newArticle.setTitle(form.getTitle());
        newArticle.setContent(form.getContent());
        newArticle.setWriter(user.getId());
        newArticle.setDateTime(LocalDateTime.now());

        boardService.addNewArticle(newArticle);

        return "redirect:/board";
    }

}
