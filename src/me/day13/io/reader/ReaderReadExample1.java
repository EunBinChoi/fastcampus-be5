package me.day13.io.reader;

import me.day13.io.util.FileUtil;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.Reader;

public class ReaderReadExample1 {
    static final String path = FileUtil.getOutPath( ReaderReadExample1.class );
    static final String filename = "input_kor.txt"; // "input_eng.txt"

    public static void main(String[] args) {
        try (
                Reader reader = new FileReader(path + filename); // 정상 출력. 한국어 깨지지 않음 (2 바이트씩 읽음)
//            Reader reader = new FileReader(path + filename); //  정상 출력
        ) {

            int readByte;

            // 읽을 수 있는 마지막 바이트까지 루프를 돌며 한 문자씩 읽음
            while ((readByte = reader.read()) != -1) {
                System.out.print((char) readByte);
            }
        } catch ( FileNotFoundException e ) {
            throw new RuntimeException(e);
        } catch ( IOException e ) {
            throw new RuntimeException(e);
        }
    }
}
