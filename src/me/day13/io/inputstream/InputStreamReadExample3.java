package me.day13.io.inputstream;


import me.day13.io.util.FileUtil;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;

public class InputStreamReadExample3 {
    static final String path = FileUtil.getOutPath( InputStreamReadExample3.class );
    static final String filename = "long.txt";
    public static void main(String[] args) {
        try (
                InputStream inputStream = new FileInputStream(path + filename);
                InputStream inputStream2 = new FileInputStream(path + filename);

        ) {

            int total = 0;
            int readByteNo = 0;
            byte[] readBytes = new byte[100];

            int count1 = 0;
            while ((readByteNo = inputStream.read(readBytes, 10, 50)) != -1) {
                count1++;
                for (int i = 10; i < readByteNo; i++) {
                    System.out.print((char)readBytes[i]);
                }
                total += readByteNo;
            }
            System.out.println("\n\ntotal bytes = " + total + " byte");
            System.out.println("count1 = " + count1);
            System.out.println();

            // 파일 다 읽으면 파일 포인터가 파일의 가장 마지막을 가르키기 때문에 다시 모든 값 초기화
            total = 0;

            int count2 = 0;
            while ( (readByteNo = inputStream2.read(readBytes, 0, 100)) != -1 ) {
                count2++;
                for (int i = 0; i < readByteNo; i++) {
                    System.out.print((char)readBytes[i]);
                }
                total += readByteNo;
            }
            System.out.println("\n\ntotal bytes = " + total + " byte");
            System.out.println("count2 = " + count2);
        } catch ( FileNotFoundException e ) {
            throw new RuntimeException(e);
        } catch ( IOException e ) {
            throw new RuntimeException(e);
        }
    }
}
