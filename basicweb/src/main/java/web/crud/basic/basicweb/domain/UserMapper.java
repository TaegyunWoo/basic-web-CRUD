package web.crud.basic.basicweb.domain;

import org.apache.ibatis.annotations.*;

@Mapper
public interface UserMapper {

    @Select("SELECT * FROM user WHERE email=#{email} and password=#{password}")
    @Results(id = "UserMap", value = {
            @Result(property = "id", column = "id"),
            @Result(property = "email", column = "email"),
            @Result(property = "name", column = "name"),
            @Result(property = "password", column = "password")
    })
    User getUserByEmailAndPassword(@Param("email") String email,
                                   @Param("password") String password);

}
