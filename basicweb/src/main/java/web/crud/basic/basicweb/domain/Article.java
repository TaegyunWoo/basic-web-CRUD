package web.crud.basic.basicweb.domain;

import lombok.Data;

import java.time.LocalDateTime;

/**
 * 게시글 도메인
 */

@Data
public class Article {
    private String title;
    private String content;
    private String writer;
    private LocalDateTime dateTime;
}
