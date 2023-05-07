package me.day13.io.reader;



import me.day13.io.util.FileUtil;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.Reader;

public class ReaderReadExample2 {
    static final String path = FileUtil.getOutPath( ReaderReadExample2.class );
    static final String filename = "long.txt";
    public static void main(String[] args) {
        try ( Reader reader = new FileReader(path + filename) ) {

            int total = 0;
            int readCharNo = 0;
            char[] cbuf = new char[100];

            // 입력 스트림으로부터 100개의 문자가 들어온다면 read() 메소드는 100번을 루핑해서 읽어들여야 함
            // 그러나 read(char[] cbuf) 메소드는 한 번 읽을 때 주어진 배열 길이만큼 읽기 때문에 루핑 횟수가 현저히 줄어듦
            // 그러므로 많은 양의 문자를 읽을 때는 read(char[] cbuf) 메소드를 사용하는 것이 좋음
            while ( (readCharNo = reader.read(cbuf)) != -1 ) {
                for (int i = 0; i < readCharNo; i++) {
                    System.out.print(cbuf[i]);
                }
                total += readCharNo;
            }
            System.out.println("\n\ntotal bytes = " + total + " byte");
        } catch ( FileNotFoundException e ) {
            throw new RuntimeException(e);
        } catch ( IOException e ) {
            throw new RuntimeException(e);
        }
    }
}
