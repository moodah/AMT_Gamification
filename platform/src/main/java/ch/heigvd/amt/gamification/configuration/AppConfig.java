package ch.heigvd.amt.gamification.configuration;

/**
 * @author Sébastien Richoz
 * @version 1.0
 * @date 18.12.2016
 */
public class AppConfig {

    public static final String X_GAMIFICATION_TOKEN = "Authorization";
    public static final int MIN_APP_NAME_LENGTH = 2;
    public static final int MAX_APP_NAME_LENGTH = 128; // TODO : nécessaire ?
    public static final int MIN_APP_PWD_LENGTH = 8;
    public static final int MAX_APP_PWD_LENGTH = 128; // TODO : nécessaire ?
}
