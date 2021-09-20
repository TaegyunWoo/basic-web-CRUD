package web.crud.basic.basicweb.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.mybatis.spring.boot.test.autoconfigure.AutoConfigureMybatis;
import org.mybatis.spring.boot.test.autoconfigure.MybatisTest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.HttpStatus;
import org.springframework.test.annotation.Rollback;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDateTime;

import static org.junit.jupiter.api.Assertions.*;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@MybatisTest
class ArticleMapperTest {

    @Autowired
    private ArticleMapper articleMapper;

    @Transactional
    @DisplayName("Insert & Select 테스트")
    @Test
    void test() {
        Article article = new Article();
        article.setTitle("Test");
        article.setDateTime(LocalDateTime.now());
        article.setWriter(1L);
        article.setContent("Test Content");
        int i = articleMapper.insertArticle(article);

        Article selectArticle = articleMapper.getById(article.getId());

        assertEquals(article.getId(), selectArticle.getId());
    }


}