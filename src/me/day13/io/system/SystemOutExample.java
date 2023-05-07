package me.day13.io.system;

import java.io.IOException;
import java.io.OutputStream;

public class SystemOutExample {
    public static void main(String[] args) {
        byte[] data = "hello".getBytes();
        try ( OutputStream os = System.out ) {
            os.write(data);
        } catch ( IOException e ) {
            throw new RuntimeException(e);
        }
    }
}
