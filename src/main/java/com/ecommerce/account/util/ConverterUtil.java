package com.ecommerce.account.util;

import java.util.List;
import java.util.function.Function;

/**
 * Utility class for converting between object types.
 */
public class ConverterUtil {

    private ConverterUtil() {}


    /**
     * Converts a list of objects from one type to another.
     *
     * @param <T>       The source type of the objects in the list.
     * @param <R>       The target type of the objects in the result list.
     * @param source    The list of source objects to be converted.
     * @param converter The function that defines how to convert from type T to type R.
     * @return A list of converted objects of type R.
     */
    public static <T, R> List<R> convertList(List<T> source, Function<T, R> converter) {
        return source
                .stream()
                .map(converter)
                .toList();
    }

}
