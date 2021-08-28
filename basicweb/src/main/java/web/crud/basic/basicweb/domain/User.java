package web.crud.basic.basicweb.domain;

import lombok.Data;

/**
 * 사용자 정보 도메인
 */
@Data
public class User {
    private String email;
    private String name;
    private String password;
}
