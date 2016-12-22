package ch.heigvd.amt.gamification.errors;

import ch.heigvd.amt.gamification.configuration.AppConfig;

/**
 * @author Christopher Browne
 * @version 1.0
 *          <p>
 *          This class is used to generate standard error messages across the whole app API.
 */
public class ErrorMessageGenerator {

    public static String nameAlreadyExists(String model, String name) {
        return model + " '" + name + "' already exists.";
    }

    public static String valueAlreadyExists(String model, String valueName, long value) {
        return model + " with " + value + " '" + valueName + "' already exists.";
    }

    public static String notFoundById(String model, String id) {
        return notFoundByField(model, "id", id);
    }

    public static String notFoundByName(String model, String name) {
        return notFoundByField(model, "name", name);
    }

    public static String notFoundByField(String model, String field, String value) {
        return "There is no " + model + " with the following " + field + ": " + value + ".";
    }

    public static String fieldMissing(String model, String field) {
        return model + " " + field + " is missing.";
    }

    public static String fieldTooShort(String model, String field, int length) {
        return model + " " + field + " must be at least " + length + " characters long.";
    }

    public static String valueTooSmall(String model, String field, int value) {
        return model + " " + field + " must be equal or greater than " + value + ".";
    }

    public static String cannotEditField(String model, String field){
        return model + " " + field + " can not be edited.";
    }
}
