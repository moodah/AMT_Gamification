package ch.heigvd.amt.gamification.filters;

import ch.heigvd.amt.gamification.model.Application;

import javax.servlet.http.HttpServletRequest;

/**
 * @author Sébastien Richoz
 * @version 1.0
 * @date 17.12.2016
 */
class Authentication {

    final static String X_GAMIFICATION_TOKEN = "Authorization";

    static Application authenticate(String jwt) {

        // TODO : check if jwt is valid
        System.out.println("jwt: " + jwt);

        if (jwt.length() > 0)
            return new Application("test", "1234");
        else
            return null;
    }

}
