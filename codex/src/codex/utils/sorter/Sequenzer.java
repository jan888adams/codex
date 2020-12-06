package codex.utils.sorter;

import codex.utils.annotations.Settable;
import codex.utils.exception.OrderAnnotationMissMatchException;

import java.io.Serializable;
import java.lang.reflect.Method;
import java.util.TreeMap;

/**
 * rdms
 *
 * @author Jan Adams
 * @version 20.11.2020
 */

public class Sequenzer {
    private final Method[] methods;

    public Sequenzer(Serializable objekt) {
        this.methods = objekt.getClass().getDeclaredMethods();
    }

    public Method[] getSeatableMethods() throws NoSuchMethodException {
        TreeMap<Integer, Method> map = new TreeMap<>();

        for (Method method : methods) {
            Settable annotation = method.getAnnotation(Settable.class);
            if (method.isAnnotationPresent(Settable.class)) {
                try {
                    map.put(annotation.order(), method);
                } catch (IllegalArgumentException e) {
                    throw new OrderAnnotationMissMatchException("Annotation order is not seated");
                }
            }
        }

        // TODO: Attribut seatableMethods erstellen und Methoden Struktur ändern, eventuell umbenennen und prüfen in wie fern die Klasse allgemeiner gemacht werden kann.

        if (map.isEmpty()) {
            throw new NoSuchMethodException("No method found whit annotation @Settable");
        }

        return map.values().toArray(new Method[0]);

    }
}
