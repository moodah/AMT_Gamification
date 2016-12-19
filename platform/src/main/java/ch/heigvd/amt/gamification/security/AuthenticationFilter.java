package ch.heigvd.amt.gamification.security;

import ch.heigvd.amt.gamification.configuration.AppConfig;

import javax.servlet.*;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

import ch.heigvd.amt.gamification.model.HttpStatusException;
import org.springframework.http.HttpStatus;

public class AuthenticationFilter implements Filter {
    private long i = 0;

    Authentication auth = new Authentication();

    @Override
    public void init(FilterConfig filterConfig) throws ServletException {

    }

    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
        System.out.println(++i + " AuthenticationFilter!");

        HttpServletRequest httpRequest = (HttpServletRequest) request;
        HttpServletResponse httpResponse = (HttpServletResponse) response;

        String jwt = httpRequest.getHeader(AppConfig.X_GAMIFICATION_TOKEN);

        if (auth.authenticate(jwt)) {
            chain.doFilter(request, response);
        } else {
//            httpResponse.sendError(HttpStatus.UNAUTHORIZED.value());
            throw new HttpStatusException(HttpStatus.UNAUTHORIZED, "Invalid token");
        }

    }

    @Override
    public void destroy() {

    }
}
