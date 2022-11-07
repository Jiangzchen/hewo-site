package org.hewo.core.utils;

import java.util.Optional;
import java.util.function.Function;

public class OptionalUtil {
    public OptionalUtil() {
    }

    public static <T, R> R ofNullable(T source, Function<T, R> function) {
        return Optional.ofNullable(source).map(function).orElse(null);
    }
}