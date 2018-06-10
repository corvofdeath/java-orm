package utils;

import java.lang.reflect.*;
import java.util.*;

public class ReflectionExtensions {

    public static List<Field> getAllFields(List<Field> fields, Class<?> type) {

        if (type.getSuperclass() != null) {
            getAllFields(fields, type.getSuperclass());
        }

        fields.addAll(Arrays.asList(type.getDeclaredFields()));

        return fields;
    }
}
