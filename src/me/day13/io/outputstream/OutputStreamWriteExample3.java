package me.day13.io.outputstream;


import me.day13.io.util.FileUtil;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;

public class OutputStreamWriteExample3 {
    static final String path = FileUtil.getOutPath( OutputStreamWriteExample3.class );
    static final String filename = "output.txt";

    public static void main(String[] args) {
        final byte[] data = "a b c d e f g h i j k".getBytes(); // "a b c d e f g h i j k"을 한꺼번에 출력

        try ( OutputStream outputStream = new FileOutputStream(path + filename) ) {
            outputStream.write(data, 2, 13); // "b c d e f g h"이 파일에 써짐
            outputStream.flush(); // buffer flush
        } catch ( FileNotFoundException e ) {
            throw new RuntimeException(e);
        } catch ( IOException e ) {
            throw new RuntimeException(e);
        }
    }
}
