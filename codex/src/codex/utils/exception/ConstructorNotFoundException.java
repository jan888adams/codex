package codex.utils.exception;

/**
 * rdms
 *
 * @author Jan Adams
 * @version 18.11.2020
 */

public class ConstructorNotFoundException extends ClassNotFoundException {

    public ConstructorNotFoundException() {
    }

    public ConstructorNotFoundException(String s) {
        super(s);
    }
}
