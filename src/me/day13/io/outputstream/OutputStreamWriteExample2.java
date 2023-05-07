package me.day13.io.outputstream;


import me.day13.io.util.FileUtil;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;

public class OutputStreamWriteExample2 {
    static final String path = FileUtil.getOutPath( OutputStreamWriteExample2.class );
    static final String filename = "output.txt";

    public static void main(String[] args) {
        final byte[] data = "a b c d e f g h i j k".getBytes(); // "a b c d e f g h i j k"을 한꺼번에 출력

        try ( OutputStream outputStream = new FileOutputStream(path + filename) ) {
            outputStream.write(data); // 대용량 파일에서는 좋음
            outputStream.flush();
        } catch ( FileNotFoundException e ) {
            throw new RuntimeException(e);
        } catch ( IOException e ) {
            throw new RuntimeException(e);
        }
    }
}
