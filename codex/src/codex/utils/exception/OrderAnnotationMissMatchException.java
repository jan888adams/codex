package codex.utils.exception;

/**
 * rdms
 *
 * @author Jan Adams
 * @version 21.11.2020
 */

public class OrderAnnotationMissMatchException extends RuntimeException {
    public OrderAnnotationMissMatchException(String message) {
        super(message);
    }
}
