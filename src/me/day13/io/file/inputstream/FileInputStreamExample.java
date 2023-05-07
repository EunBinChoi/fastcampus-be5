package me.day13.io.file.inputstream;

import me.day13.io.util.FileUtil;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;

public class FileInputStreamExample {
    static final String path = FileUtil.getOutPath( FileInputStreamExample.class );
    static final String fileName = "input.txt";
    public static void main(String[] args) {


        try ( InputStream is = new FileInputStream(path + fileName) ) {
            // FileNotFoundException

			/*int data = is.read();
            System.out.print((char)data + ", ");
            System.out.println(data);
			// 1 바이트를 읽음 (더이상 읽을 수 없으면 -1 리턴)
			// 'a': 1바이트
			// '가': 2바이트 (euc-kr), 3바이트 (utf-8)

			while((data = is.read()) != -1) {

				System.out.print((char)data + ", ");
				System.out.println(data);
				// enter: cr (13) + lf (10) (windows)
				// 		: cr (13) (mac)
			}*/

            byte[] data = new byte[10]; // buffer
            int dataNo;
            while ((dataNo = is.read(data))!= -1) {
                for (int i = 0; i < dataNo; i++) {
                    System.out.print((char)data[i] + ", ");
                    System.out.println(data[i]);
                }
            }

        } catch ( FileNotFoundException e ) {
            throw new RuntimeException(e);
        } catch ( IOException e ) {
            throw new RuntimeException(e);
        }
    }
}
