/**
 * Validation utility methods
 */
public class ValidationUtils {

    public static boolean isValidAge(int age) {
        return age > 0 && age <= 100;
    }

    public static boolean isValidGrade(double grade) {
        return grade >= 0 && grade <= 100;
    }

    public static boolean isValidString(String value) {
        return value != null && !value.trim().isEmpty();
    }
}
