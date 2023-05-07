package me.day13.io.inputstream;


import me.day13.io.util.FileUtil;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;

public class InputStreamReadExample1 {
    static final String path = FileUtil.getOutPath( InputStreamReadExample1.class );
    static final String filename = "input_eng.txt"; // "input_kor.txt"

    public static void main(String[] args) {

        try ( InputStream inputStream = new FileInputStream(path + filename) ) {
            int readByte;

            // 읽을 수 있는 마지막 바이트까지 루프를 돌며 한 바이트씩 읽음
            while ( (readByte = inputStream.read()) != -1 ) {
                System.out.print((char) readByte);
            }
//            inputStream.close(); // 어떤 문제가 생길 수 있을까? (읽는 도중 문제가 생기면 inputStream 안 닫힐 수도 있음)
        } catch ( FileNotFoundException e ) {
            // FileNotFoundException 문제가 생길 경우 전략
            throw new RuntimeException(e);
        }  catch ( IOException e ) {
            // IO 문제가 생길 경우 전략
            throw new RuntimeException(e);
        }
    }
}
