package ch.heigvd.amt.gamification.security;

import ch.heigvd.amt.gamification.annotations.Authenticate;
import ch.heigvd.amt.gamification.configuration.AppConfig;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Component;
import org.springframework.web.method.HandlerMethod;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * This class intercepts all queries to our API.
 * If a method is annotated with our specific annotation, then it will be
 * pre handled with the preHandle() method.
 * Here we want to check authentication for specific requests and give an
 * error as a response if authentication failes
 */
@Component
public class AuthenticationInterceptor extends HandlerInterceptorAdapter {

    Authentication auth = new Authentication();

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws IOException {
        HandlerMethod handlerMethod = (HandlerMethod ) handler;

        Authenticate authAnnotation = handlerMethod.getMethodAnnotation(Authenticate.class);
        String jwt;

        if (authAnnotation != null) {
            if (authAnnotation.auth()) {
                jwt = request.getHeader(AppConfig.X_GAMIFICATION_TOKEN);
                return auth.authenticate(jwt);
            } else {
                response.sendError(HttpStatus.UNAUTHORIZED.value());
                return false; // cancel default lifecycle
            }
        }

        return true;
    }

}
