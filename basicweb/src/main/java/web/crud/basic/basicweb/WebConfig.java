package web.crud.basic.basicweb;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
import web.crud.basic.basicweb.login.LoginCheckInterceptor;
import web.crud.basic.basicweb.login.LogoutInterceptor;

@Configuration
public class WebConfig implements WebMvcConfigurer {
    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        registry.addInterceptor(new LoginCheckInterceptor())
                .order(1)
                .addPathPatterns("/**")
                .excludePathPatterns("/", "/logout", "/css/bootstrap.min.css");
        registry.addInterceptor(new LogoutInterceptor())
                .order(2)
                .addPathPatterns("/board");
    }
}
