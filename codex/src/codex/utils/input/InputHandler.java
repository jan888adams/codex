package codex.utils.input;

import codex.utils.sql.SqlInjectionHandler;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

/**
 * rdms
 *
 * @author Jan Adams
 * @version 10.11.2020
 */

public class InputHandler {
    private final Queue<String> inputs;
    private final Scanner scanner;

    public InputHandler() {
        scanner = new Scanner(System.in);
        inputs = new LinkedList<>();
    }

    public String obtain() {
        return scanner.nextLine();
    }

    public void save(String input) {
        inputs.add(new SqlInjectionHandler().replaceNotAllowedCharacters(input));
    }

    public Queue<String> getInputs() {
        return inputs;
    }
}
