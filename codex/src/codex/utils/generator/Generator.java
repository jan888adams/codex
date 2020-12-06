package codex.utils.generator;

import java.util.Random;

/**
 * java_fx
 *
 * @author Jan Adams
 * @version 30.11.2020
 */

public class Generator {

    public String fielName(){
        int leftLimit = 97;
        int rightLimit = 122;
        int targetStringLength = 10;
        Random random = new Random();

        return random.ints(leftLimit, rightLimit + 1)
                .limit(targetStringLength)
                .collect(StringBuilder::new, StringBuilder::appendCodePoint, StringBuilder::append)
                .toString();
    }
}
