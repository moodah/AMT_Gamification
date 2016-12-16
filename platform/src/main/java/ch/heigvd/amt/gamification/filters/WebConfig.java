package ch.heigvd.amt.gamification.filters;

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

        // TODO : voir comment faire pour filtrer avec des annotations sur les controlleurs/les méthodes
        Collection<String> urlpatterns = new LinkedList<>();
//        urlpatterns.add("/badges");
//        urlpatterns.add("/events");
//        urlpatterns.add("/leaderbords");
        registrationBean.setUrlPatterns(urlpatterns);
        System.out.println("*****************************LIST OF URL PATTERNS FILTERED*****************************");
        for (String s : registrationBean.getUrlPatterns())
            System.out.println(s);
        return registrationBean;
    }

}
