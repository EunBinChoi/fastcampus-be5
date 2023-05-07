package me.day13.io.file.reader;


import me.day13.io.util.FileUtil;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.Reader;

public class FileReaderExample {
    static final String path = FileUtil.getOutPath( FileReaderExample.class );
    static final String filename = "input.txt";
    public static void main(String[] args) {


        try ( Reader reader = new FileReader(path + filename) ) {


			/*int data = reader.read();
            System.out.print((char)data + ", ");
            System.out.println(data);
			// 1 바이트를 읽음 (더이상 읽을 수 없으면 -1 리턴)
			// 'a': 1바이트
			// '가': 2바이트 (euc-kr), 3바이트 (utf-8)

			while((data = reader.read()) != -1) {

				System.out.print((char)data + ", ");
				System.out.println(data);
				// enter: cr (13) + lf (10) (windows)
				// 		: cr (13) (mac)
			}*/

            char[] data = new char[10];
            int dataNo = 0;
            while ((dataNo = reader.read(data)) != -1) {
                for (int i = 0; i < dataNo; i++) {
                    System.out.print(data[i] + ", ");
                    System.out.println((int)data[i]);
                }
            }

        } catch ( FileNotFoundException e ) {
            throw new RuntimeException(e);
        } catch ( IOException e ) {
            throw new RuntimeException(e);
        }
    }
}
