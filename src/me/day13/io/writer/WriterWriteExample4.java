package me.day13.io.writer;


import me.day13.io.util.FileUtil;

import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.io.Writer;

public class WriterWriteExample4 {
    static final String path = FileUtil.getOutPath( WriterWriteExample4.class );
    static final String filename = "output.txt";

    public static void main(String[] args) {
        final String str = "안녕하세요. 파일 입출력 예제입니다.";

        try ( Writer writer = new FileWriter(path + filename) ) {
//            writer.write(str);
            writer.write(str, 1, 12);
            writer.flush();
        } catch ( FileNotFoundException e ) {
            throw new RuntimeException(e);
        } catch ( IOException e ) {
            throw new RuntimeException(e);
        }
    }
}
