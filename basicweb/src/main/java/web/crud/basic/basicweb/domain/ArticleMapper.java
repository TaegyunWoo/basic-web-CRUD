package web.crud.basic.basicweb.domain;

import org.apache.ibatis.annotations.*;

import java.util.List;

@Mapper
public interface ArticleMapper {

    @Insert("INSERT INTO article (title, content, writer, datetime) VALUES (#{article.title}, #{article.content}, #{article.writer}, #{article.dateTime})")
    @Options(useGeneratedKeys = true, keyColumn = "id")
    int insertArticle(@Param("article") Article article);

    @Select("SELECT * FROM article")
    @Results(id = "ArticleMap", value = {
            @Result(property = "id", column = "id"),
            @Result(property = "title", column = "title"),
            @Result(property = "content", column = "content"),
            @Result(property = "writer", column = "writer"),
            @Result(property = "dateTime", column = "datetime")
    })
    List<Article> getAll();

    @Select("SELECT * FROM article WHERE id=#{id}")
    @ResultMap("ArticleMap")
    Article getById(@Param("id") Long id);

    @Select("SELECT * FROM article WHERE writer=#{userId}")
    @ResultMap("ArticleMap")
    Article getByWriter(@Param("userId") String userId);


}
