package me.day13.io.writer;



import me.day13.io.util.FileUtil;

import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.io.Writer;

public class WriterWriteExample3 {
    static final String path = FileUtil.getOutPath( WriterWriteExample3.class );
    static final String filename = "output.txt";
    public static void main(String[] args) {
        final char[] data = "가 나 다 라 마 바 사 아".toCharArray(); // 자바에서 한글 지원하기 때문에 (유니코드) 깨지지 않음
//            char[] data = "a b c d e f g h i j k".toCharArray(); // "a b c d e f g h i j k"을 한꺼번에 출력

        try ( Writer writer = new FileWriter(path + filename) ) {
            writer.write(data, 2, 11);
            writer.flush();
        } catch ( FileNotFoundException e ) {
            throw new RuntimeException(e);
        } catch ( IOException e ) {
            throw new RuntimeException(e);
        }
    }
}
