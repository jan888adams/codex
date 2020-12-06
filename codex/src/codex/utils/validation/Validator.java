package codex.utils.validation;

/**
 * rdms
 *
 * @author Jan Adams
 * @version 14.11.2020
 */

public class Validator {

    /**
     * @param name  allow german spezial Characters
     * @return false if name not matches german name pattern
     */

    public static boolean isValidName(String name) {
        String germanNamePattern = "[A-ZÄÖÜ][A-Za-zäöüß -]+";
        return name.matches(germanNamePattern);
    }

    /**
     * Email Pattern:
     * 1) A-Z characters allowed
     * 2) a-z characters allowed
     * 3) 0-9 numbers allowed
     * 4) Additionally email may contain only dot(.), dash(-) and underscore(_)
     * 5) Rest all characters are not allowed
     * <p>
     * validation permitted by RFC 5322
     * restrict leading, trailing, or consecutive dots in emails
     *
     *
     * @param email - not englisch characters are not allowed
     * @return false if email not match the email pattern
     */

    public static boolean isValidEmail(String email) {
        String emailPattern = "^[a-zA-Z0-9_!#$%&'*+/=?`{|}~^.-]+@[a-zA-Z0-9.-]+$";
        return email.matches(emailPattern);
    }


}
