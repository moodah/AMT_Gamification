package ch.heigvd.amt.gamification.security;

import ch.heigvd.amt.gamification.configuration.AppConfig;

import javax.servlet.*;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

import ch.heigvd.amt.gamification.errors.HttpStatusException;
import org.springframework.http.HttpStatus;

public class AuthenticationFilter implements Filter {

    Authentication auth = new Authentication();

    @Override
    public void init(FilterConfig filterConfig) throws ServletException {

    }

    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {

        HttpServletRequest httpRequest = (HttpServletRequest) request;

        String jwt = httpRequest.getHeader(AppConfig.X_GAMIFICATION_TOKEN);

        if (auth.authenticate(jwt)) {
            chain.doFilter(request, response);
        } else {
            ((HttpServletResponse)response).sendError(HttpServletResponse.SC_FORBIDDEN, "The Authorization token is missing or malformed!");
        }
    }

    @Override
    public void destroy() {

    }
}
