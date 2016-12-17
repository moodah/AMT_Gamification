package ch.heigvd.amt.gamification.filters;

import ch.heigvd.amt.gamification.model.Application;

import javax.servlet.*;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

import org.springframework.http.HttpStatus;

public class AuthenticationFilter implements Filter {
    private long i = 0;
    @Override
    public void init(FilterConfig filterConfig) throws ServletException {

    }

    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
        System.out.println(++i + " AuthenticationFilter!");

        HttpServletRequest httpRequest = (HttpServletRequest) request;
        HttpServletResponse httpResponse = (HttpServletResponse) response;

        String jwt = httpRequest.getHeader(Authentication.X_GAMIFICATION_TOKEN);
        Application application = Authentication.authenticate(jwt);

        if (application != null) {
            request.setAttribute("app", application);
            chain.doFilter(request, response);
        } else {
            httpResponse.sendError(HttpStatus.UNAUTHORIZED.value());
        }

    }

    @Override
    public void destroy() {

    }
}
