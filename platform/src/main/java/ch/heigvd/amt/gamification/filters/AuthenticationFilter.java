package ch.heigvd.amt.gamification.filters;

import ch.heigvd.amt.gamification.model.Application;

import javax.servlet.*;
import java.io.IOException;

public class AuthenticationFilter implements Filter {
    @Override
    public void init(FilterConfig filterConfig) throws ServletException {

    }

    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
        System.out.println("AuthenticationFilter!");
        // TODO : check le token et récupérer l'app correspondante ou renvoyer une erreur
//        request.setAttribute("application", new Application()); // pour passer l'application au controlleur
        chain.doFilter(request, response);
    }

    @Override
    public void destroy() {

    }
}
