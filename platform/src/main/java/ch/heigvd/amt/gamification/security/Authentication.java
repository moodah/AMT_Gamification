package ch.heigvd.amt.gamification.security;

import ch.heigvd.amt.gamification.model.Application;
import ch.heigvd.amt.gamification.model.HttpStatusException;
import ch.heigvd.amt.gamification.model.Token;
import com.auth0.jwt.JWT;
import com.auth0.jwt.JWTVerifier;
import com.auth0.jwt.algorithms.Algorithm;
import com.auth0.jwt.exceptions.JWTCreationException;
import com.auth0.jwt.exceptions.JWTDecodeException;
import com.auth0.jwt.exceptions.JWTVerificationException;
import org.springframework.http.HttpStatus;
import java.io.UnsupportedEncodingException;
import java.util.Random;

/**
 * @author Sébastien Richoz
 * @version 1.0
 * @date 17.12.2016
 */
public class Authentication {

    private static final String claimApp = "app";

    private static final String secret = String.valueOf(new Random(System.currentTimeMillis()).nextLong());

    boolean authenticate(String token) {

        JWT jwt;

        // Decode token
        try {
            jwt = JWT.decode(token);
        } catch (JWTDecodeException exception){
            //Invalid token
//            System.out.println("Invalid token");
            return false;
        }

        // Verify token
        try {
            JWTVerifier verifier = JWT.require(Algorithm.HMAC256(secret))
                    .withIssuer(jwt.getIssuer())
                    .withClaim(claimApp, jwt.getClaim(claimApp).asString())
                    .build(); //Reusable verifier instance
            jwt = (JWT) verifier.verify(token);
        } catch (JWTVerificationException exception){
            //Invalid signature/claims
//            System.out.println("Invalid signature/claims");
            return false;
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        }

        return true;
    }

    public static Token generateToken(Application application) {

        String token = null;
        try {
            token = JWT.create()
                    .withIssuer(String.valueOf(application.getId()))
                    .withClaim(claimApp, application.getName())
                    .sign(Algorithm.HMAC256(secret));
        } catch (JWTCreationException exception){
            throw new HttpStatusException(HttpStatus.CONFLICT, "Invalid Signing configuration / Couldn't convert Claims");
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        }

        return new Token(token);
    }

    public static long getId(String token) {
        JWT jwt;

        // Decode token
        try {
            jwt = JWT.decode(token);
        } catch (JWTDecodeException exception){
            //Invalid token
            return -1;
        }

        return Long.parseLong(jwt.getIssuer());
    }

}
