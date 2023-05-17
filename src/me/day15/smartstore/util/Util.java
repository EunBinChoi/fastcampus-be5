package me.day15.smartstore.util;

import java.util.Arrays;
import java.util.Objects;

public class Util {
    public static boolean isAnyNUll(Object... objects) {
        return Arrays.stream(objects).anyMatch(Objects::isNull);
    }

    public static boolean isAnyNonNUll(Object... objects) {
        return Arrays.stream(objects).anyMatch(Objects::nonNull);
    }

    public static boolean isAllNUll(Object... objects) {
        return Arrays.stream(objects).allMatch(Objects::isNull);
    }

    public static boolean isAllNonNUll(Object... objects) {
        return Arrays.stream(objects).allMatch(Objects::nonNull);
    }
}
