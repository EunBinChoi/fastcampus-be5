package me.day15.smartstore.util;

import java.util.Arrays;
import java.util.Objects;

public class UtilMethod {
    public static boolean isAnyNUll(Object... objects) {
        return Arrays.stream(objects).anyMatch(Objects :: isNull);
    }

    public static boolean isAllNUll(Object... objects) {
        return Arrays.stream(objects).allMatch(Objects :: isNull);
    }
}
