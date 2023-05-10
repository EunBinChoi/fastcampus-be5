package me.day13.io.outputstream;

import me.day13.io.util.FileUtil;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;

public class OutputStreamWriteExample1 {
    static final String path = FileUtil.getOutPath( OutputStreamWriteExample1.class );
    static final String filename = "output.txt";

    public static void main(String[] args) {
        final byte[] data = "가 나 다 라 마 바 사 아".getBytes(); // 자바에서 한글 지원하기 때문에 (유니코드) 깨지지 않음
//            byte[] data = "a b c d e f g h i j k".getBytes(); // "a", "b", "c" ... "k"를 하나씩 출력

//        try(자원 (스트림)) {} catch {}

        try ( OutputStream outputStream = new FileOutputStream(path + filename) ) {
            for (int i = 0; i < data.length; i++) {
                outputStream.write(data[i]);
            }
            outputStream.flush();
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
