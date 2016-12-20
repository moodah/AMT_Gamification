package ch.heigvd.amt.gamification.annotations;

import java.lang.annotation.Retention;
import java.lang.annotation.Target;

import static java.lang.annotation.ElementType.METHOD;
import static java.lang.annotation.RetentionPolicy.RUNTIME;

/**
 * Custom annotation to add to every method which need authentication
 */
@Target(value=METHOD)
@Retention(value=RUNTIME)
public @interface Authenticate {
    boolean auth() default true;
}

