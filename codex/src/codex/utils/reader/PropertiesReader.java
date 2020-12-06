package codex.utils.reader;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

/**
 * rdms
 *
 * @author Jan Adams
 * @version 08.11.2020
 */

public class PropertiesReader{

    public Properties read(String fileName) {

        Properties properties = null;

        try (FileInputStream inputStream = new FileInputStream(fileName)) {
            properties = new Properties();
            properties.load(inputStream);
        } catch (FileNotFoundException e) {
            e.getLocalizedMessage();
        } catch (IOException e) {
            e.printStackTrace();
        }

        return properties;
    }
}
