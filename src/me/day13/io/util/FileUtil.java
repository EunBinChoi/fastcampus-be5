package me.day13.io.util;

import java.io.File;

public class FileUtil {
    public static String getOutPath(Class<?> clazz) {
        return clazz.getResource("").getPath();
    }

    public static String getSrcPath(Class<?> clazz) {
        final String internalPath = clazz.getName().replace(".", File.separator);
        final String workspace = System.getProperty("user.dir") + File.separator + "src";
        final String packagePath = workspace + File.separator + internalPath.substring(0, internalPath.lastIndexOf(File.separator));
        return packagePath;
    }

    public static void main(String[] args) {
        System.out.println( getOutPath(FileUtil.class) );
        System.out.println( getSrcPath(FileUtil.class) );
    }
}
