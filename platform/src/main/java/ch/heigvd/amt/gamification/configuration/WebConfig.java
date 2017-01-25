package ch.heigvd.amt.gamification.configuration;

import ch.heigvd.amt.gamification.security.AuthenticationFilter;
import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.Collection;
import java.util.LinkedList;

@Configuration
public class WebConfig {

    @Bean
    public FilterRegistrationBean authFilterRegistrationBean() {
        FilterRegistrationBean registrationBean = new FilterRegistrationBean();
        registrationBean.setName("authFilter");
        AuthenticationFilter authFilter = new AuthenticationFilter();
        registrationBean.setFilter(authFilter);
        registrationBean.setOrder(1);

        Collection<String> urlpatterns = new LinkedList<>();
        urlpatterns.add("/achievements");
        urlpatterns.add("/achievements/*");
        urlpatterns.add("/badges");
        urlpatterns.add("/badges/*");
        urlpatterns.add("/events");
        urlpatterns.add("/events/*");
        urlpatterns.add("/eventtypes");
        urlpatterns.add("/eventtypes/*");
        urlpatterns.add("/leaderboards");
        urlpatterns.add("/leaderboards/*");
        urlpatterns.add("/levels");
        urlpatterns.add("/levels/*");
        urlpatterns.add("/users");
        urlpatterns.add("/users/*");

        registrationBean.setUrlPatterns(urlpatterns);
        System.out.println("*****************************LIST OF URL PATTERNS FILTERED*****************************");
        for (String s : registrationBean.getUrlPatterns())
            System.out.println(s);
        return registrationBean;
    }

}
