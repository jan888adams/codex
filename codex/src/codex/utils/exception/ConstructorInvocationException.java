package codex.utils.exception;

/**
 * rdms
 *
 * @author Jan Adams
 * @version 18.11.2020
 */

public class ConstructorInvocationException extends ExceptionInInitializerError {

    public ConstructorInvocationException(String s) {
        super(s);
    }
}
