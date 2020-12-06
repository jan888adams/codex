package codex.utils.exception;

/**
 * rdms
 *
 * @author Jan Adams
 * @version 18.11.2020
 */

public class ModelNotFoundException extends ClassNotFoundException{
    public ModelNotFoundException(String s) {
        super(s);
    }

    public ModelNotFoundException() {
    }
}
