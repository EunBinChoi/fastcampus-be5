package me.day09.exception.close_finallys;

import java.io.Closeable;
import java.io.IOException;

public interface Close {
    static void close(Closeable closeable) {
        if (closeable != null) {
            try {
                closeable.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}
