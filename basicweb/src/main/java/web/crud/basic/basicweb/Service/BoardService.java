package web.crud.basic.basicweb.Service;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import web.crud.basic.basicweb.domain.Article;
import web.crud.basic.basicweb.domain.ArticleMapper;

import java.util.List;

@Slf4j
@RequiredArgsConstructor
@Service
public class BoardService {

    private final ArticleMapper articleMapper;

    @Transactional
    public List<Article> getAllArticles() {
        List<Article> articles = articleMapper.getAll();
        return articles;
    }

    @Transactional
    public boolean addNewArticle(Article article) {
        int success = articleMapper.insertArticle(article);
        if (success == 0) {
            return false;
        }
        return true;
    }

}
